package Daily.August;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author rope
 * @Date 2020/8/21 21:12
 * @Version 1.0
 */
/*
* 529
* */
public class Test20 {
    int[] dirX = new int[]{0,1,1,0,-1,-1,1,-1};
    int[] dirY = new int[]{1,0,1,-1,0,1,-1,-1};
    public char[][] updateBoard(char[][] board, int[] click){
        int clickX = click[0];
        int clickY = click[1];
        if(board[clickX][clickY] == 'M'){
            board[clickX][clickY] = 'X';
        }else {
            dfs(board,clickX,clickY);
            bfs(board,clickX,clickY);
        }
        return board;
    }

    private void bfs(char[][] board, int clickX, int clickY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.add(new int[]{clickX,clickY});
        vis[clickX][clickY] = true;
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int sx = poll[0];
            int sy = poll[1];
            int count = 0;
            for(int i = 0;i < dirX.length;i++){
                int x = sx + dirX[i];
                int y = sy + dirY[i];
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                if(board[x][y] == 'M') count++;
            }
            if(count > 0) board[sx][sy] = (char)(count + '0');
            if(count == 0){
                board[sx][sy] = 'B';
                for(int i = 0;i < dirX.length;i++){
                    int x = sx + dirX[i];
                    int y = sy + dirY[i];
                    if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E' || vis[x][y]) continue;
                    queue.add(new int[]{x,y});
                    vis[x][y] = true;
                }
            }
        }
    }

    private void dfs(char[][] board, int clickX, int clickY) {
        int count = 0;
        for(int i = 0;i < dirX.length;i++){
            int x = clickX + dirX[i];
            int y = clickY + dirY[i];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if(board[x][y] == 'M') count++;
        }
        if(count > 0) board[clickX][clickY] = (char)(count + '0');
        if(count == 0){
            board[clickX][clickY] = 'B';
            for(int i = 0;i < dirX.length;i++){
                int x = clickX + dirX[i];
                int y = clickY + dirY[i];
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') continue;
                dfs(board,x,y);
            }
        }
    }
}
