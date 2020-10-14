package Series.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author rope
 * @Date 2020/8/31 0:54
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
        int n = rooms.size();
        //去重
        boolean[] vis = new boolean[n];
        bfs(rooms,0,vis);
        return num == n;
    }

    private void bfs(List<List<Integer>> rooms, int i, boolean[] vis) {
        vis[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            Integer pos = queue.poll();
            num++;
            List<Integer> list = rooms.get(pos);
            for (int j = 0;j < list.size();j++){
                if(!vis[list.get(j)]){
                    vis[list.get(j)] = true;
                    queue.add(list.get(j));
                }
            }
        }
    }
}
