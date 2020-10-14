package Series.BackTrace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/8/26 9:38
 * @Version 1.0
 */
/*
* 造化弄人 没想到是这道题目
* 电话号码的字母组合
* https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
* */
public class Test17 {
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character,char[]> map = new HashMap<>();
        int len = digits.length();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        backtrack(digits,len,0,new StringBuilder().append(""),map);
        return res;
    }

    private void backtrack(String digits, int len, int index, StringBuilder sb, HashMap<Character,char[]> map) {
        if(index == len){
            res.add(sb.toString());
            return;
        }
        char temp = digits.charAt(index);
        char[] chars = map.get(temp);
        for(int i = 0;i < chars.length;i++){
            sb.append(chars[i]);

            backtrack(digits, len, index+1, sb, map);

            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test17().letterCombinations("23"));
    }
}
