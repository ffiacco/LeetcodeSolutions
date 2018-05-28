/**
*Given a string, find the length of the longest substring without repeating characters.
*/

//queue solution

import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return s.length();
        
        char[] characters = s.toCharArray();
        Queue<Character> charsSoFar = new LinkedBlockingQueue<Character>();
        int max = 1, current = 0;
        char head;
        
        for (int i = 0; i < characters.length; i++){
            if (charsSoFar.contains(characters[i])){
                do{
                    head = charsSoFar.remove();
                    current--;
                } while (head != characters[i]);
            }
            charsSoFar.add(characters[i]);
            if (++current > max){
                max = current;
            }
        }
        
        return max;
    }
}