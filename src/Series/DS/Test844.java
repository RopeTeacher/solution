package Series.DS;

import java.util.LinkedList;

/**
 * @Author rope
 * @Date 2020/10/19 8:37
 * @Version 1.0
 */
public class Test844 {
    public boolean backspaceCompare(String S, String T) {
        LinkedList<Object> list1 = new LinkedList<>();
        LinkedList<Object> list2 = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (list1.size() == 0 && S.charAt(i) == '#') {
            } else if (S.charAt(i) == '#') {
                list1.removeLast();
            } else
                list1.addLast(S.charAt(i));

        }
        for (int i = 0; i < T.length(); i++) {
            if (list2.size() == 0 && T.charAt(i) == '#') {
            } else if (T.charAt(i) == '#') {
                list2.removeLast();
            } else
                list2.addLast(T.charAt(i));
        }
        if(list1.size() != list2.size()){
            return false;
        }else {
            for(int i = 0;i < list1.size();i++){
                if(list1.get(i) != list2.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
