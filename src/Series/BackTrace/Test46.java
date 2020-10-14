package Series.BackTrace;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/8/26 0:06
 * @Version 1.0
 */
/*
* 全排列
* https://leetcode-cn.com/problems/permutations/
* */
public class Test46 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null) return res;
        boolean[] vis = new boolean[nums.length];
        backTrace(nums,0,vis);
        return res;
    }

    private void backTrace(int[] nums,int index,boolean[] vis) {
        if(index == nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++){
            if(!vis[i]){
                temp.add(nums[i]);
                vis[i] = true;

                backTrace(nums,index+1,vis);

                vis[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test46().permute(new int[]{1,2,3}));
    }
}
