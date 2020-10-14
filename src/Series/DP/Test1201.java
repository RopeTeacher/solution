package Series.DP;

import java.util.Arrays;

/*
* 1201. 丑数
* 请你帮忙设计一个程序，用来找出第 n 个丑数。丑数是可以被 a 或 b 或 c 整除的 正整数。
* https://leetcode-cn.com/problems/ugly-number-iii/
* */
public class Test1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int flagA = 1;
        int flagB = 1;
        int flagC = 1;
        for(int i=1;i<=n;i++){

            dp[i] = Math.min(Math.min(flagA*a,flagB*b),flagC*c);

            if(dp[i] == flagA*a) flagA++;
            if(dp[i] == flagB*b) flagB++;
            if(dp[i] == flagC*c) flagC++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Test1201().nthUglyNumber(5,2,11,13));
    }
}
