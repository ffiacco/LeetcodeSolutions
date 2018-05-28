/**
*Given a string, find the length of the longest substring without repeating characters.
*/

//brute force solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length < 2)
            return s.length;
        char[] characters = s.toCharArray();
        List<Character> charsSoFar = new ArrayList<Character>();
        int max = 1;
        int j = 0;
        
        for (int i = 0; i< characters.length - max; i++){
            j = i;
            while (j < characters.length && !charsSoFar.contains(characters[j])){
                charsSoFar.add((Character)characters[j]);
                j++;
            }
            if (charsSoFar.size() > max){
                max = charsSoFar.size();
            }
            charsSoFar = new ArrayList<Character>();
        }
        
        return max;
    }
}