package Series.Smart;

/**
 * @Author oroch
 * @Date 2020/8/30 15:24
 * @Version 1.0
 */
/*
* 557 反转字符串中的单词III
* https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
* */
public class Test557 {
    //将字符串分成字符串数组
    //再对字符串进行反转
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String str : strings){
            String reverse = reverse(str);
            res.append(reverse);
            res.append(" ");
        }

        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    private String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Test557().reverseWords("Let's take LeetCode contest"));
    }
}
