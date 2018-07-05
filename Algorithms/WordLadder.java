/*Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        q.add(null);
        
        Set<String> wordListSet = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();
        
        if (!wordListSet.contains(endWord))
            return 0;
        
        int distance = 1;
        
        while (!q.isEmpty()){
            String str = q.poll();
            
            if (str != null) {
                for (int i = 0; i < str.length(); i++){
                    char[] characters = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++){
                        characters[i] = c;
                        String newWord = new String(characters);


                        if (newWord.equals(endWord))
                            return distance + 1;

                        if (wordListSet.contains(newWord) && !visited.contains(newWord) && !newWord.equals(beginWord)){
                            System.out.println(newWord);
                            q.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            } else {
                distance++;

                if (!q.isEmpty()) { 
                    q.add(null);
                }
            }
            
        }
        
        return 0;
    }
}