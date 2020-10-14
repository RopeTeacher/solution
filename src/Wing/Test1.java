package Wing;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//物品数量
        int V = sc.nextInt();//背包容积
        int[] w = new int[N+1];
        int[] va = new int[N+1];
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();//体积
            va[i] = sc.nextInt();//价值
        }
        //dp[i][j] 为面对i件物品时，重量为j的价值最大值
        //如果可以放 最大值为
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + va[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
