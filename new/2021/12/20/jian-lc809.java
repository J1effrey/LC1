class Solution {
    public int expressiveWords(String s, String[] words) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (words == null || words.length == 0) {
            return 0;
        }
        int res = 0;
        for (String candidate: words) {
            if (canExtend(s, candidate)) {
                res++;
            }
        }
        
        return res;
    }
    
     public boolean canExtend(String S, String word) {
        if (word == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(S, i);
                int len2 = getRepeatedLength(word, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }
    
    public int getRepeatedLength(String str, int start) {
        int end = start;
        while (end < str.length() && str.charAt(end) == str.charAt(start)) {
            end++;
        }
        return end - start;
    }
}
