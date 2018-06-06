//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that 
//a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return result;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int z = j + 1; z < nums.length; z++){
                    int key = target - (nums[i] + nums[j] + nums[z]);
                    if (map.containsKey(key) && map.get(key) > z){
                        ArrayList<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(nums[i]); quadruplet.add(nums[j]); quadruplet.add(nums[z]); quadruplet.add(key);
                        if (!containsQuadruplet(result, quadruplet))
                            result.add(quadruplet);
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean containsQuadruplet(ArrayList<List<Integer>> result, List<Integer> quadruplet){
        for (List<Integer> q : result){
            if (new HashSet<>(q).equals(new HashSet<>(quadruplet)))
                return true;
        }
        
        return false;
    }
}