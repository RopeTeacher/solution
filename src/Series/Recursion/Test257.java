package Series.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/4 22:24
 * @Version 1.0
 */
/*
* 257.二叉树的所有路径
* https://leetcode-cn.com/problems/binary-tree-paths/
* */
public class Test257 {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        helper(root,"");
        return res;
    }

    private void helper(TreeNode root, String s) {
        if(root == null) return;
        s += Integer.valueOf(root.val);
        if(root.left == null && root.right == null){
            res.add(s);
        }else {
            s += "->";
            helper(root.left,s);
            helper(root.right,s);
        }
    }
}
