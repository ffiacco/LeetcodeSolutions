//remove duplicates from sorted array

class Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        while (i < result - 1){
            if (nums[i] == nums[i + 1]){
                this.shift(nums, i, result);
                result--;
            } else
                i++;
        }
        
        return result;
    }
    
    public void shift(int[] nums, int index, int end){
        for (int i = index; i < end - 1; i++){
            nums[i] = nums[i + 1];
        }
    }
}