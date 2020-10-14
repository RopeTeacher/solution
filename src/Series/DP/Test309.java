package Series.DP;

/**
 * @Author rope
 * @Date 2020/9/1 9:39
 * @Version 1.0
 */
/*
* 309.股票买卖含冷冻期
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
* */
public class Test309 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null) return 0;
        //两种状态 一种该天持有股票 一种该天不持有股票
        int n = prices.length;
        //dp[i][j] = x  第i天 j=1表示持股,j=0表示不持股,x表示收益。
        //从第0天开始
        int[][] dp = new int[n+1][2];
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1;i <= n;i++){
            //第i天不持股-->第i-1天也不持股;第i-1天持股(所持股份为prices[i-1]) i天卖出
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i-1]);
            //第i天持股-->之间就持股了;之前未持股(前天，因为冷冻期),今天买入
            if(i >= 2){
                dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0] - prices[i-1]);
            }else
                dp[i][1] = -prices[i-1];
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(new Test309().maxProfit(new int[]{1,2,3,0,2}));
    }
}
