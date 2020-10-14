package Series.Smart;

/**
 * @Author rope
 * @Date 2020/8/24 17:54
 * @Version 1.0
 */
public class Test459 {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()==1) return true;
        StringBuilder s1 = new StringBuilder(s + s);
        s1.deleteCharAt(0);
        s1.deleteCharAt(s1.length()-1);
        if(s1.indexOf(s)!=-1) return true;
        return false;
    }
}
