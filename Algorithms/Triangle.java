//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return minimumTotalDP(triangle, 0, 0, memo);
    }
    
    public int minimumTotalDP(List<List<Integer>> triangle, int level, int index, int[][] memo){
        int[] sums = new int[2];
        for (int i = 0; i <= 1; i++){
            if (level < triangle.size() - 1)
                if (memo[level + 1][index + i] != 0){
                    sums[i] = memo[level + 1][index + i];
                } 
                else{
                    sums[i] = minimumTotalDP(triangle, level + 1, index + i, memo);
                    memo[level + 1][index + i] = sums[i];
                }
            else
                sums[i] = 0;
        }
        
        return triangle.get(level).get(index) + Math.min(sums[0], sums[1]);
    }
}