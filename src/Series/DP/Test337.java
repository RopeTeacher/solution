package Series.DP;

/**
 * @Author rope
 * @Date 2020/9/14 11:30
 * @Version 1.0
 */
/*
* 337. 打家劫舍 III
* https://leetcode-cn.com/problems/house-robber-iii/
* */
public class Test337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];

        //当前不偷 双儿子的最大值之和
        dp[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]) ;
        //当前偷 当前加孙子
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }
    

}
