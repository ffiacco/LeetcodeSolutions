/**
*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i=0; i< nums.length; i++){
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                int result[] = {i, map.get(target - nums[i])};
                return result;
            }
        }
        
        return null;
    }
}