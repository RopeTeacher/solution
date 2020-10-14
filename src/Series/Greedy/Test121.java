package Series.Greedy;

/**
 * @Author rope
 * @Date 2020/8/22 0:31
 * @Version 1.0
 */
/*
* 121 股票买卖
* https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
* */
public class Test121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0) return 0;
            int min = prices[0];int max = 0;
            for(int i=0;i<prices.length;i++){
                if(min > prices[i]) min = prices[i];
                if(prices[i] - min > max) max = prices[i] - min;
            }
            return max;
        }
    }
}
