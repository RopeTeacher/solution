package Series.Double;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/10/14 10:43
 * @Version 1.0
 */
/*
* 15.三数之和
*https://leetcode-cn.com/problems/3sum/
* */
public class Test15 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums){
        //使用多指针法需要原数组有序，这里采用复杂度为nlogn的快速排序
        Arrays.sort(nums);
        if(nums.length < 3) return res;
        //三数之和，1数循环为，两数为指针
        for(int i = 0;i < nums.length;i++){
            //a+b+c = 0如果最小值都大于0，那就没有必要继续下去了
            if(nums[i] > 0) break;
            //如果此次循环到的数和之前的数相同，为了避免重复则需要跳出此次循环
            if(i >=1 && nums[i] == nums[i-1]) continue;

            //设置双指针
            int j = i+1,k = nums.length-1;
            while(k > j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;j++;
                    //双指针也需要去重
                    while (k > j && nums[k] == nums[k+1])
                        k--;
                    while (k > j && nums[j] == nums[j-1])
                        j++;
                }else if(sum > 0){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return res;
    }
}
