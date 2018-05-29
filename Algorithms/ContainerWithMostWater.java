class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, currentArea = 0;
        int i = 0, j = height.length - 1;
        
        while (i != j){
            currentArea = getArea(height[i], i , height[j], j);
            maxArea = (currentArea > maxArea) ? currentArea : maxArea;
            if (height[i] < height[j]) 
                i++;
            else
                j--;
        }
        
        return maxArea;
    }
    
    private int getArea(int a0, int i0, int a1, int i1){
        return (a0 < a1) ? a0 * Math.abs(i1 - i0) : a1 * Math.abs(i1-i0);
    }
}