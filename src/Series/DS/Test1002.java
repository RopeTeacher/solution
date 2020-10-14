package Series.DS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/10/14 8:32
 * @Version 1.0
 */
/*
* 1002.查找常用字符
* https://leetcode-cn.com/problems/find-common-characters/
* */
public class Test1002 {
    List<String> res = new ArrayList<>();
    public List<String> commonChars(String[] A) {
        int[] least = new int[26];
        Arrays.fill(least,Integer.MAX_VALUE);
        //计数问题通常可以使用map或者单纯的数组来解决
        for (String str : A){
            //题目限定小写字母，所以数组长度为26
            int[] temp = new int[26];
            for(char c : str.toCharArray()){
                temp[c - 'a']++;
            }
            for(int i = 0;i < temp.length;i++){
                least[i] = Math.min(least[i],temp[i]);
            }
        }

        for (int i = 0;i < least.length;i++){
            if(least[i] != 0){
                for (int j = 0;j < least[i];j++){
                    res.add(String.valueOf((char)('a'+i)));
                }
            }
        }
        return res;
    }
}
