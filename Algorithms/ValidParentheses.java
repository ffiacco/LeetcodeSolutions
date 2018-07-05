/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/

class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> string = new Stack<Character>();
        
        for (int i = 0; i < str.length; i++){
            if (!string.isEmpty() && this.isMatch(string.peek(), str[i]))
                string.pop();
            else
                string.push(str[i]);
        }
        
        return string.isEmpty();
    }
    
    private boolean isMatch(char a, char b){
        if (a == '(' && b == ')')
            return true;
        if (a == '[' && b == ']')
            return true;
        if (a == '{' && b == '}')
            return true;
        
        return false;
    }
}