package Series.BackTrace;

/**
 * @Author rope
 * @Date 2020/9/15 19:40
 * @Version 1.0
 */
/*
* 37.解数独
* https://leetcode-cn.com/problems/sudoku-solver/
* */
public class Test37 {
    final int row = 9,col = 9;
    public void solveSudoku(char[][] board) {
        if(backTrace(board,0,0))return;
    }

    private boolean backTrace(char[][] board, int r, int c) {
        if(r == row) return true;
        if(c == col){
            return backTrace(board,r+1,0);
        }

        for(int r1 = r;r1 < 9;r1++){
            for (int c1 = c;c1 < 9;c1++){
                if(board[r1][c1] != '.'){
                    return backTrace(board,r1,c1+1);
                }
                for(char ch = '1';ch <= '9';ch++){
                    if(!isValid(board,r1,c1,ch)){
                        continue;
                    }
                    board[r1][c1] = ch;
                    if(backTrace(board,r1,c1+1)){
                        return true;
                    }
                    board[r1][c1] = '.';
                }
                return false;
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int r1, int c1, char ch) {
        for(int i = 0;i < 9;i++){
            if(board[r1][i] == ch) return false;
            if(board[i][c1] == ch) return false;
            if(board[(r1/3)*3 + i/3][(c1/3)*3 + i%3] == ch)return false;
        }
        return true;
    }
}
