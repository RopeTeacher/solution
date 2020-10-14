package Series.DP;

/*
* 最长回文子串
* https://leetcode-cn.com/problems/longest-palindromic-substring/*/

public class Test5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1 || s == null) return s;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i < len;i++){
            //表示单个字符始终是回文字符串 第i个开始 第i个结束
            dp[i][i] = true;
        }

        int start = 0; int max = 1;
        for(int j = 1;j < len;j++){

            for (int i = 0;i < j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j < 3+i){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else {
                    dp[i][i] = false;
                }

                if(dp[i][j]){
                    int cur = j-i+1;
                    if (cur > max){
                        max = cur;start = i;
                    }
                }
            }

        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        System.out.println(new Test5().longestPalindrome("ad"));
    }
}
