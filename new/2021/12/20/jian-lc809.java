// T:O(L*Min{O(S), O(W)}) w is word's average length. L is words length. s is string length
// S:O(1)
class Solution {
    public int expressiveWords(String s, String[] words) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        if (words == null || words.length == 0) {
            return 0;
        }
        
        int res = 0;
        
        for (String candidate : words) {
            if (canExtend(s, candidate)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean canExtend(String s, String candidate) {
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < s.length() && p2 < candidate.length()) {
            char c1 = s.charAt(p1);
            char c2 = candidate.charAt(p2);
            if (c1 != c2) {
                return false;
            }
            int repeat1 = getRepeatedTimes(s, p1);
            int repeat2 = getRepeatedTimes(candidate, p2);
            
            if (repeat1 < repeat2) {
                return false;
            } 
            
            if (repeat1 > repeat2 && repeat1 < 3) {
                return false;
            } 
            
            p1 += repeat1;
            p2 += repeat2; 
        }
        
        return p1 == s.length() && p2 == candidate.length();
        
    }
    
    private int getRepeatedTimes(String s, int start) {
        int end = start;
        while (end < s.length() && s.charAt(end) == s.charAt(start)) {
            end++;
        }

        return end - start; 
    }
}
