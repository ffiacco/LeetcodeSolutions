//Given a m x n grid filled with non-negative numbers, 
//find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//Note: You can only move either down or right at any point in time.

class Solution {
    public int minPathSum(int[][] grid) {
        int columns = grid[0].length,
            rows = grid.length;
        
        int[][] sums = new int[rows][columns];
        
        sums[0][0] = grid[0][0];
        
        for (int i = 1; i < columns; i++){
            sums[0][i] = sums[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < rows; i++){
            sums[i][0] = sums[i - 1][0] + grid[i][0];;
        }  
        
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns; j++){
                sums[i][j] = Math.min(sums[i][j - 1] + grid[i][j], sums[i - 1][j] + grid[i][j]);
            }
        }
        
        return sums[rows - 1][columns - 1];
    }
}