package Series.SW;

import java.util.HashSet;

/**
 * @Author rope
 * @Date 2020/9/3 13:14
 * @Version 1.0
 */
/*
* 3. 无重复字符的最长子串
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
* */
public class Test3 {
    //不重复的最长字串 需要去重 可以使用Set
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int i = 0;int j = 0;
        int res = 0;
        while (i < n && j < n){
            if(!set.contains(s.charAt(i))){
                //如果没有,就加入,i指针往后移
                set.add(s.charAt(i));
                i++;
                res = Math.max(i-j,res);
            }else {
                //如果已有 需要删除(知道把第一次出现的删了 j指针的作用)
                set.remove(s.charAt(j));
                j++;
            }
        }
        return res;
    }
}
