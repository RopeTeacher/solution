package Daily.October;

/**
 * @Author rope
 * @Date 2020/10/16 10:09
 * @Version 1.0
 */
public class Test1 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        for(char c : s1.toCharArray()){
            if(c>='0'&&c<='9' || c>='a'&&c<='z'){
                sb.append(c);
            }
        }
        String s2 = sb.toString();
        int left = 0; int right = s2.length() - 1;
        int mid = left + (right - left)/2;
        while (right > left){
            if(s2.charAt(left++) != s2.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
