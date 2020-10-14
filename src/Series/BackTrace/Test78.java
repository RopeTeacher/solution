package Series.BackTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/20 10:52
 * @Version 1.0
 */
/*
* 78. 子集
* https://leetcode-cn.com/problems/subsets/
* */
public class Test78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        backTrace(nums,path,n,0);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> path, int n, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start;i < n;i++){
            path.add(nums[i]);

            backTrace(nums,path,n,i+1);

            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test78().subsets(new int[]{1,2,3}));
    }
}
