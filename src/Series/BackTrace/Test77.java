package Series.BackTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/8 20:01
 * @Version 1.0
 */
/*
* 77.组合
* https://leetcode-cn.com/problems/combinations/
* */
public class Test77 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) return res;
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        backTrace(n, k, path, 1);
        return res;
    }

    private void backTrace(int n, int k, LinkedList<Integer> path, int begin) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
        }
        for (int i = begin; i <= n; i++) {
            path.add(i);

            backTrace(n, k, path, i + 1);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test77().combine(4, 2));
    }
}
