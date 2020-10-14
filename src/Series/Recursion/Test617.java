package Series.Recursion;

/**
 * @Author rope
 * @Date 2020/9/23 14:25
 * @Version 1.0
 */
/*
617.合并1二叉树
https://leetcode-cn.com/problems/merge-two-binary-trees/
* */
public class Test617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)return t2;
        if(t2 == null)return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}
