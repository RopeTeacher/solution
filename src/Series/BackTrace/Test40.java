package Series.BackTrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/10 8:42
 * @Version 1.0
 */
/*
* 40. 组合总和 II
* https://leetcode-cn.com/problems/combination-sum-ii/
* */
public class Test40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target <= 0) return res;
        //先进性排序 在进行回溯
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backTrace(candidates,target,path,0);
        return res;
    }

    private void backTrace(int[] candidates, int target, List<Integer> path,int index) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i < candidates.length;i++){
            if(target < candidates[i]) break;
            if(i > index &&(candidates[i] == candidates[i-1])) continue;
            path.add(candidates[i]);
            backTrace(candidates,target-candidates[i],path,i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test40().combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
}
