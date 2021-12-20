/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) {
            return;    
        }
        
        Random random = new Random();
        
        for (int i = 0; i < 10; i++) {
            int matches = 0;
            
            String guess = wordlist[random.nextInt(wordlist.length)]; 
            matches = master.guess(guess);
            
            if (matches == 6) {
                break;
            }
            
            List<String> candidates = new ArrayList<>();
            for(String word: wordlist){
                if(getMatches(guess, word) == matches){
                    candidates.add(word);
                }
            }
            
            wordlist = candidates.toArray(new String[0]);
        }
    }
    
    private int getMatches(String word1, String word2){
        int matches = 0;
        for(int i = 0; i < word1.length(); i ++){
            if(word1.charAt(i) == word2.charAt(i)){
                matches ++;
            }
        }
        
        return matches;
    }
}
