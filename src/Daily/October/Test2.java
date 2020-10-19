package Daily.October;

/**
 * @Author rope
 * @Date 2020/10/19 8:57
 * @Version 1.0
 */
public class Test2 {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int left = 0;int right = s.length() - 1;
        while (right > left){
            if(!isValid(sb.charAt(left))) left++;
            if(!isValid(sb.charAt(right))) right--;
            if(isValid(sb.charAt(left)) && isValid((sb.charAt(right)))){
                char temp = s.charAt(left);
                sb.setCharAt(left,s.charAt(right));
                sb.setCharAt(right,temp);
                left++;
                right--;
            }
        }
        return sb.toString();
    }
    public boolean isValid(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new Test2().reverseVowels("latu"));
    }
}
