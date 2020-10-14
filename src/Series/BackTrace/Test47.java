package Series.BackTrace;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/18 0:27
 * @Version 1.0
 */
/*
* 全排列ii
* https://leetcode-cn.com/problems/permutations-ii/
* 给定一个可包含重复数字的序列，返回所有不重复的全排列。
* */
public class Test47 {
    List<List<Integer>> res = new ArrayList<>();
    //简单去重
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length <= 0)return res;
        int len = nums.length;
        boolean[] vis = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backTrace(nums,path,len,vis,0);
        return res;
    }

    private void backTrace(int[] nums, List<Integer> path, int len, boolean[] vis, int index) {
        if(index == len){
            if(!set.contains(new ArrayList<>(path))){
                set.add(new ArrayList<>(path));
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = 0;i < len;i++){
            if(!vis[i]){
                path.add(nums[i]);
                vis[i] = true;

                backTrace(nums, path, len, vis, index+1);

                vis[i] = false;
                path.remove(path.size()-1);
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(new Test47().permuteUnique(new int[]{1,1,2}));
    }
}
