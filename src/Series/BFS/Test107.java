package Series.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author rope
 * @Date 2020/9/6 9:17
 * @Version 1.0
 */
/*
* 107 二叉树的层次遍历II
* https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
* */
public class Test107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            res.add(0,new ArrayList<>());
            int size = queue.size();
            for (int i = 0;i < size;i++){
                TreeNode e = queue.remove();
                res.get(0).add(e.val);

                if(e.left != null) queue.add(e.left);
                if(e.right != null) queue.add(e.right);
            }
        }
        return res;
    }
}
