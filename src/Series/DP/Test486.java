package Series.DP;

/**
 * @Author rope
 * @Date 2020/9/1 19:55
 * @Version 1.0
 */
/*
* 486. 预测赢家
* https://leetcode-cn.com/problems/predict-the-winner/
*
* 定义数组dp[][],dp[i][j]为当剩下的数组的下标为i到j时的分差最大值
*
* i > j 是无意义的  即二维数组的对角线的下半部分是不用考虑的
* i = j 当前玩家可选次数 dp[i][j] = nums[i]
* i < j 可以选左边的，也可以选右边的
* dp[i][j] = max(num[i] - dp[i+1][j] , num[j] - dp[i][j-1])
* */
public class Test486 {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length == 0) return true;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++){
            dp[i][i] = nums[i];
        }
        for(int i = n-2;i >=0;i--){
            for (int j = i+1;j < n;j++){
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
