package Series.Greedy;

/**
 * @Author rope
 * @Date 2020/8/22 0:17
 * @Version 1.0
 */
/*
 * 122 股票买卖2
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * */
public class Test122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0;i < prices.length-1;i++){
            if(prices[i+1] > prices[i]) max += prices[i+1] - prices[i];
        }
        return max;
    }
}
