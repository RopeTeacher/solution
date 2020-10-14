package Series.DFS;
/*
*https://leetcode-cn.com/problems/minesweeper/ */
public class Test529 {
    int[] dirX = new int[]{0,1,1,-1,-1,0,-1,1};
    int[] dirY = new int[]{1,0,1,-1,0,-1,1,-1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int clickx = click[0]; int clicky = click[1];
        if(board[clickx][clicky] == 'M'){
            board[clickx][clicky] = 'X';
        }else {
            dfs(board,clickx,clicky);
        }
        return board;
    }

    private void dfs(char[][] board, int clickx, int clicky) {
        int count = 0;
        for(int i = 0;i < dirX.length;i++){
            int x = clickx + dirX[i];
            int y = clicky + dirY[i];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
                continue;
            }
            if(board[x][y] == 'M'){
                count++;
            }
        }
        if(count > 0){
            board[clickx][clicky] = (char)(count + '0');
        }
        //周围没有地雷 需要深度优先寻找地雷
        if(count == 0){
            //首先标记
            board[clickx][clicky] = 'B';
            for(int i = 0;i < dirX.length;i++){
                int x = clickx + dirX[i];
                int y = clicky + dirY[i];
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E'){
                    continue;
                }
                dfs(board,x,y);
            }
        }
    }
}
