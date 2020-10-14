package Series.BackTrace;

import com.sun.deploy.net.proxy.pac.PACFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/8/27 14:29
 * @Version 1.0
 */
/*
* 39.组合总和
* 做加法会出现stackoverflow的错误，并且剪枝也不好剪
所以这里我们做减法
* 而且为了去重 循环的下一次就从当前位开始
* */
public class Test39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backTrace(candidates,target,0,path);
        return res;
    }

    private void backTrace(int[] candidates, int target, int index,List<Integer> path) {
        if(target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index;i < candidates.length;i++){
            if(target < candidates[i]) break;

            path.add(candidates[i]);
            backTrace(candidates,target-candidates[i],i,path);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Test39().combinationSum(new int[]{2,3,6,7},7));
    }
}
