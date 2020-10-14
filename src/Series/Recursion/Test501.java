package Series.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/24 9:03
 * @Version 1.0
 */
/*
* 501. 二叉搜索树中的众数
https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * */
public class Test501 {
    //看到计数 想到hashmap,看到二叉树想到递归，但这种解法二叉搜索树的性质没有用上
    List<Integer> path = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        inorder(root);
        //哈希表计数
        int max = 0;
        for(int p : path){
            if(!map.containsKey(p)){
                map.put(p,1);
            }else {
                map.put(p,map.get(p)+1);
                max = Math.max(max,map.get(p));
            }
        }
        List<Integer> temp = new ArrayList<>();
        for (int k : map.keySet()){
            if(map.get(k) == max){
                temp.add(k);
            }
        }
        int[] res = new int[temp.size()];
        for(int i = 0;i < temp.size();i++){
            res[i] = temp.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if(root != null){
            inorder(root.left);
            path.add(root.val);
            inorder((root.right));
        }
    }
}
