//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below)
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 0; 
        
        for (int i = 1; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++){
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                
                int left = (i == 0) ? 0 : dp[i - 1][j];
                int up = (j == 0) ? 0 : dp[i][j - 1];
                
                dp[i][j] = left + up;
            }
        }
        
        return dp[m - 1][n - 1];
    }
}