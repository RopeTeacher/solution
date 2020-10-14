package Series.DFS;

/**
 * @Author rope
 * @Date 2020/9/13 10:02
 * @Version 1.0
 */
/*
* 79. 单词搜索
* https://leetcode-cn.com/problems/word-search/
*
* 找到第一个匹配的字符，然后深度优先进行搜索
* */
public class Test79 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        boolean[][] vis = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                if(board[i][j] == chars[0]){
                    if(dfs(board,chars,i,j,0,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board,char[] chars, int row, int col, int index,boolean[][] vis) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != chars[index] || vis[row][col])
            return false;
        if (index == chars.length -1 && board[row][col] == chars[index]) return true;
        vis[row][col] = true;
        boolean res = dfs(board,chars,row+1,col,index+1,vis) ||
                dfs(board,chars,row-1,col,index+1,vis) ||
                dfs(board,chars,row,col-1,index+1,vis) ||
                dfs(board,chars,row,col+1,index+1,vis);
        vis[row][col] = false;
        return res;
    }
}
