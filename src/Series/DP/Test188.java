package Series.DP;

/**
 * @Author rope
 * @Date 2020/9/2 21:57
 * @Version 1.0
 */
/*
* 188. 买卖股票的最佳时机 IV
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
* */
public class Test188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];

        for(int i = 0;i < n ;i++){
            for(int j = 1; j <= k;j++){
                //第一天
                if(i == 0){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                }else {
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
                }

            }
        }
        //int max = Integer.MIN_VALUE;
        //for(int i = 1;i <= k;i++){
        //    max = Math.max(max,dp[n-1][i][0]);
        //}
        //
        //return max;
        return dp[n-1][k][0];
    }

    public static void main(String[] args) {
        System.out.println(new Test188().maxProfit(2,new int[]{2,4,1}));
    }
}
