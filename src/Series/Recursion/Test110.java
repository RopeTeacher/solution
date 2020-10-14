package Series.Recursion;

/**
 * @Author rope
 * @Date 2020/8/21 15:16
 * @Version 1.0
 */
/*
* 110. 平衡二叉树  给定一个二叉树，判断它是否是高度平衡的二叉树。
* https://leetcode-cn.com/problems/balanced-binary-tree/
* */
public class Test110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
