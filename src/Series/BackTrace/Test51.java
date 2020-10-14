package Series.BackTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/3 10:28
 * @Version 1.0
 */
public class Test51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> solution = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            solution.add(sb.toString());
        }
        backTrace(solution, 0, n);
        return res;
    }

    private void backTrace(List<String> solution, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < n; i++) {
            //如果当前位置能放，那就将该位置的"."替换为"Q"
            if (isValid(index, i, solution, n)) {
                //做出选择
                StringBuilder temp = new StringBuilder(solution.get(index));
                temp.setCharAt(i, 'Q');
                solution.set(index, temp.toString());
                //回溯
                backTrace(solution, index + 1, n);
                //恢复现场
                temp = new StringBuilder(solution.get(index));
                temp.setCharAt(i, '.');
                solution.set(index, temp.toString());
            }
        }
    }

    private boolean isValid(int index, int i, List<String> solution, int n) {
        //不同列不能相同
        for (int row = 0; row < index; row++) {
            if (solution.get(row).charAt(i) == 'Q') return false;
        }
        //左对角
        for (int row = index - 1, col = i - 1; row >= 0 && col >= 0; row--, col--) {
            if (solution.get(row).charAt(col) == 'Q') return false;
        }
        //右对角
        for (int row = index - 1, col = i + 1; row >= 0 && col < n; row--, col++) {
            if (solution.get(row).charAt(col) == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test51().solveNQueens(4));
    }

}
