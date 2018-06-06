//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        
        int max = nums[0], sum = nums[0];
        
        for (int i = 1; i < nums.length; i++){
            sum = Math.max((sum + nums[i]), nums[i]);
            if (sum > max)
                max = sum;
        }
        
        return max;
    }
}