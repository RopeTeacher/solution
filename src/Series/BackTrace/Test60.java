package Series.BackTrace;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/5 7:33
 * @Version 1.0
 */
/*
* 60.第k个排列
* https://leetcode-cn.com/problems/permutation-sequence/
*
* 笨办法：全排列+排序 输出第k个
* 根据题意 不用考虑重复元素
* */
public class Test60 {
    List<String> res = new LinkedList<>();
    public String getPermutation(int n, int k) {
        List<String> list = getPermutations(n,k);
        return list.get(k-1);
    }

    private List<String> getPermutations(int n,int k) {
        if(n == 0) return res;
        boolean[] vis = new boolean[n+1];
        StringBuilder sb = new StringBuilder("");
        backTrace(0,n,sb,vis,k);
        return res;
    }

    private void backTrace(int index, int n, StringBuilder sb,boolean[] vis,int k) {
        if( res.size() == k) return;
        if(index == n){
            res.add(sb.toString());
            return;
        }
        for(int i = 1;i <= n;i++){
            if(!vis[i]){
                sb.append(i);
                vis[i] = true;

                backTrace(index+1,n,sb,vis,k);

                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new Test60().getPermutation(9,353955));
    }
}
