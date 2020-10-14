package Series.BackTrace;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/11 9:09
 * @Version 1.0
 */
/*
* 216. 组合总和 III
* https://leetcode-cn.com/problems/combination-sum-iii/
* */
public class Test216 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) return res;
        List<Integer> path = new LinkedList<>();
        backTrace(path,k,n,1);
        return res;
    }

    private void backTrace(List<Integer> path, int k, int n,int start) {
        if(path.size() == k && n == 0){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i <= 9;i++){
            path.add(i);

            backTrace(path,k,n - i,i+1);

            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test216().combinationSum3(3,7));
    }
}
