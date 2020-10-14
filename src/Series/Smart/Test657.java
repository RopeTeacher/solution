package Series.Smart;

/**
 * @Author rope
 * @Date 2020/8/28 0:32
 * @Version 1.0
 */
/*
*657. 机器人能否返回原点
* https://leetcode-cn.com/problems/robot-return-to-origin/
* */
public class Test657 {
    public boolean judgeCircle(String moves) {
        int x = 0;int y = 0;
        for(int i = 0;i < moves.length();i++){
            if(moves.charAt(i) == 'U') x++;
            if(moves.charAt(i) == 'D') x--;
            if(moves.charAt(i) == 'L') y++;
            if(moves.charAt(i) == 'R') y--;
        }
        return x==0 && y==0;
    }
}
