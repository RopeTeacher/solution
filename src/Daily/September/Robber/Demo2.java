package Daily.September.Robber;

import java.rmi.MarshalException;
import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/10 16:33
 * @Version 1.0
 */
/*
* 213. 打家劫舍 II
* https://leetcode-cn.com/problems/house-robber-ii/
* */
public class Demo2 {
    /*
    * 环状相连 即第一家和最后一家只能选择偷一家
    * 分两种情况考虑
    * 第一种：偷第一家 即rob(nums[0,nums.length-1])
    * 第二种：偷最后一家 即rob(nums[1,nums.length])
    * */
    public int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(getRob(Arrays.copyOfRange(nums,0,nums.length-1)),
                getRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int getRob(int[] nums) {
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
        System.out.println(new Demo2().rob(new int[]{2,3,2}));
    }

}
