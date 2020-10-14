package Series.DS;



import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author rope
 * @Date 2020/9/14 0:18
 * @Version 1.0
 */
/*
* 94. 二叉树的中序遍历
* https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
* */
public class Test94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode pop = stack.pop();
                res.add(pop.val);
                cur = pop.right;
            }
        }
        return res;
    }
}
