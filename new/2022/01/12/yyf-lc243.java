// O(N*M) N is the number of words in the input list, and MM is the total length of two input words.
// O(1)
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) 
                p1 = i;

            if (words[i].equals(word2)) 
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }
}
