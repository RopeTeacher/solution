package Series.DS;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author rope
 * @Date 2020/10/2 18:48
 * @Version 1.0
 */
//771.宝石与石头
public class Test771 {
    public int numJewelsInStones(String J, String S) {
        //计数问题，可以使用hash数据结构来解决
        HashSet<Character> set = new HashSet<>();
        for(char c : J.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(char c2 : S.toCharArray()){
            if (set.contains(c2))
                res++;
        }
        return res;
    }
}
