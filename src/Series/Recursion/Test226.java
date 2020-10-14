package Series.Recursion;

/**
 * @Author rope
 * @Date 2020/9/16 0:24
 * @Version 1.0
 */
/*
* 226. 翻转二叉树
* https://leetcode-cn.com/problems/invert-binary-tree/
* */
public class Test226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        helper(root);

        return root;
    }

    private void helper(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        helper(root.left);
        helper(root.right);
    }
}
