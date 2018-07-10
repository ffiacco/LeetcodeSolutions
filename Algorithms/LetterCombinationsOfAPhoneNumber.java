//Given a string containing digits from 2-9 inclusive, return all possible letter 
//combinations that the number could represent like in a phone

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        
        if (digits == null || digits.equals(""))
            return result;
        
        result.add("");
        
        while(result.peek().length() != digits.length()){
            String str = result.remove();
            String possibleChars = this.charsFromNumber(digits.charAt(str.length()));
            for (char c : possibleChars.toCharArray()){
                result.addLast(str + c);
            }
        }
        
        return result;
    }
    
    private String charsFromNumber(char c){
        int number = Character.getNumericValue(c);
        switch (number){
            case 2: 
                return "abc";
            case 3: 
                return "def";
            case 4: 
                return "ghi";
            case 5: 
                return "jkl";
            case 6: 
                return "mno";
            case 7: 
                return "pqrs";
            case 8: 
                return "tuv";
            case 9: 
                return "wxyz";
            default:
                return "";
        }
    }
}