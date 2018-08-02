//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or //vertically neighboring. The same letter cell may not be used more than once.

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (existFrom(i, j, board, word, visited))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean existFrom(int i, int j, char[][] board, String word, boolean[][] visited){
        if ((i < 0 || i > board.length - 1) || (j < 0 || j > board[0].length - 1) || visited[i][j])
            return false;
        
        if (board[i][j] != word.charAt(0))
            return false;
        
        visited[i][j] = true;
        
        word = word.substring(1, word.length());
        if (word.equals(""))
            return true;
        
        if (existFrom(i - 1, j, board, word, visited) || existFrom(i, j - 1, board, word, visited) || existFrom(i, j + 1, board, word, visited) || existFrom(i + 1, j, board, word, visited))
            return true;
        
        visited[i][j] = false;
        return false;
    }
}