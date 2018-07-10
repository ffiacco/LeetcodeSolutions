//implement strStr()

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        
        boolean flag = false;
        int i = 0;
        
        while (i < haystack.length() && !flag){
            flag = true;
            if (haystack.length() - i < needle.length())
                return -1;
            
            for (int j = 0; j < needle.length() && flag; j++){
                if (haystack.charAt(i + j) != needle.charAt(j))
                    flag = false;
            }
            
            if (!flag)
                i++;
        }
        
        if (flag)
            return i;
        
        return -1;
    }
}