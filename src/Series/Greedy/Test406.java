package Series.Greedy;

public class Test406 {
    /*
     * 给定一个包含大写字母和小写字母的字符串，
     * 找到通过这些字母构造成的最长的回文串。*/
    public int longestPalindrome(String s) {
        //首先使用计数数组计数
        int[] counts = new int[1000];
        for(char c : s.toCharArray()){
            counts[c]++;
        }

        int res = 0;
        //把回文看作是左右两边
        for(int c : counts){
            res += c/2*2;
            //假如碰上第一个奇数 可以加进去
            if(res%2==0&&c%2==1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test406().longestPalindrome("abccccdd"));
    }
}
