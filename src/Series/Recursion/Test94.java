package Series.Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/14 0:08
 * @Version 1.0
 */
/*
* 94. 二叉树的中序遍历
* https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
* */
public class Test94 {
    //中序遍历 ===>  左根右
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
