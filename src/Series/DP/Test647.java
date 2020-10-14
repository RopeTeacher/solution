package Series.DP;

/*
* 回文子串
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
* 具有不同开始位置或结束位置的子串，
* 即使是由相同的字符组成，也会被视作不同的子串。
* https://leetcode-cn.com/problems/palindromic-substrings/
* */
public class Test647 {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for(int i = 0;i < len;i++){
            dp[i][i] = true;
            count++;
        }
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
                if(dp[i][j]) count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Test647().countSubstrings("aaa"));
    }
}
