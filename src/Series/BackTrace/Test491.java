package Series.BackTrace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author rope
 * @Date 2020/8/25 10:14
 * @Version 1.0
 */
/*
* /*
 * 491. 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * 思路：找出所有子集 然后判断这些子集是否是递增序列
 * 当测试用例比较多时会出现超时的情况
 * 需要想别的解决办法  试试回溯算法
 * */
public class Test491 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        if(nums.length < 2) return res;
        //参数：cur为当前坐标 preP为之前值的值
        backtrace(nums,-1);
        return res;
    }

    private void backtrace(int[] nums,int cur) {
        if(temp.size()>=2){
            res.add(new ArrayList<>(temp));
        }
        Set<Integer> set = new HashSet();
        for(int i = cur+1;i < nums.length;i++){
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            if(cur == -1 || nums[i] >= nums[cur]){
                temp.add(nums[i]);
                backtrace(nums,i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
