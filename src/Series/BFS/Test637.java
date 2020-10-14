package Series.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author rope
 * @Date 2020/9/12 0:31
 * @Version 1.0
 */
/*
* 637. 二叉树的层平均值
* https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
* */
public class Test637 {
    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double temp = 0;
            for (int i = 0;i < size;i++){
                TreeNode node = queue.poll();
                temp += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(temp/size);
        }
        return res;
    }
}
