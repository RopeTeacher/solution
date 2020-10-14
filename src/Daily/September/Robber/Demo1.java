package Daily.September.Robber;

/**
 * @Author rope
 * @Date 2020/9/10 16:14
 * @Version 1.0
 */
/*
* 198. 打家劫舍
* https://leetcode-cn.com/problems/house-robber/
* */
public class Demo1 {
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = nums[0];
        //假设dp[i]为小偷站在第i间(nums[i-1])屋子前
        for(int i = 2;i <= n;i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Demo1().rob(new int[]{1,2,3,1}));
    }
}
