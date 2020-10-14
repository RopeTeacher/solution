package Series.Recursion;

/**
 * @Author rope
 * @Date 2020/8/21 16:32
 * @Version 1.0
 */
public class Test111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return minDepth(root.right) + 1;
        if (root.left != null && root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
