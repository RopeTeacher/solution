package Series.Double;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/10/14 11:50
 * @Version 1.0
 */
/*
* 18.四数之和
* https://leetcode-cn.com/problems/4sum/
* */
public class Test18 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return res;
        //排序
        Arrays.sort(nums);
        for (int i = 0;i <nums.length-3;i++){
            if(nums[i] + nums[i+1] + nums[i+2]+nums[i+3] > target) break;
            if(i >= 1 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1;j < nums.length-2;j++){
                if(j>i + 1 && nums[j] == nums[j-1]) continue;
                int k = j+1;int l = nums.length-1;
                while (l > k){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;l--;
                        while (l > k && nums[k] == nums[k-1])
                            k++;
                        while (l > k && nums[l] == nums[l+1]){
                            l--;
                        }
                    }else if(sum > target){
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test18().fourSum(new int[]{-2,-1,-1,1,1,2,2},0));
    }
}
