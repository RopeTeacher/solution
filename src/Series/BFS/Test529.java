package Series.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author rope
 * @Date 2020/8/20 22:12
 * @Version 1.0
 */
public class Test529 {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};


    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0]; int y = click[1];
        if(board[x][y] == 'M'){

            board[x][y] = 'X';
        }else{
            bfs(board,x,y);
        }
        return board;
    }

    private void bfs(char[][] board, int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx,sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0;i < dirX.length;i++){
                int tx = x+dirX[i];
                int ty = y+dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }

                if(board[tx][ty] == 'M'){
                    ++cnt;
                }
            }
            if(cnt > 0){

                board[x][y] = (char)(cnt + '0');
            }else {

                board[x][y] = 'B';
                for (int i = 0; i < dirX.length; ++i) {
                    int tx = x + dirX[i];
                    int ty = y + dirY[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }


}
