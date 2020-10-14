package Series.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/8/31 0:05
 * @Version 1.0
 */
/*
* 841. 钥匙和房间
* https://leetcode-cn.com/problems/keys-and-rooms/
*
* */
public class Test841 {
    int num = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //计算房间个数
        int n = rooms.size();
        //去重
        boolean[] vis = new boolean[n];
        dfs(rooms,0,vis);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int i,boolean[] vis) {
        vis[i] = true;
        num++;
        for(int j:rooms.get(i)){
            if(!vis[j]){
                dfs(rooms, j, vis);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();l1.add(1);
        List<Integer> l2 = new ArrayList<>();l2.add(2);
        List<Integer> l3 = new ArrayList<>();l3.add(3);
        List<Integer> l4 = new ArrayList<>();
        rooms.add(l1);
        rooms.add(l2);
        rooms.add(l3);
        rooms.add(l4);
        System.out.println(rooms);
        System.out.println(new Test841().canVisitAllRooms(rooms));
    }
}
