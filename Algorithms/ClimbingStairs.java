//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        return climbMemoization(n, map);
    }
    
    private int climbMemoization(int n, HashMap<Integer, Integer> map){
        if (n <= 2)
            return n;
        
        
        int climb1, climb2;
        
        if (map.containsKey(n - 1)){
            climb1 = map.get(n - 1);
        } else {
            climb1 = climbMemoization(n - 1, map);
            map.put(n - 1, climb1);
        }
        
        if (map.containsKey(n - 2)){
            climb2 = map.get(n - 2);
        } else {
            climb2 = climbMemoization(n - 2, map);
            map.put(n - 2, climb2);
        }
        
        return climb1 + climb2;
    }
}