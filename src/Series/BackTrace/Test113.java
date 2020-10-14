package Series.BackTrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/26 21:41
 * @Version 1.0
 */
public class Test113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null || root.val > sum) return res;
        List<Integer> path = new LinkedList<>();
        backTrace(path,sum,root);
        return res;
    }

    private void backTrace(List<Integer> path, int sum, TreeNode root) {
        if(root == null) return;

        sum -= root.val;
        path.add(root.val);

        if(sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
            //左和右只能走一条
            path.remove(path.size()-1);
            return;
        }

        backTrace(path,sum,root.left);
        backTrace(path,sum,root.right);

        path.remove(path.size()-1);
    }
}
