class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        if (t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (int i = 0; i < t.length(); i++) {
            int count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }
        
        int uniqueNumOfChars = tMap.size();
        int matchedNumOfChars = 0;
        int left = 0;
        int right = 0;
        int leftOfRes = 0;
        int rightOfRes = 0;
        int minLen = Integer.MAX_VALUE;
        
        Map<Character, Integer> wMap = new HashMap<Character, Integer>();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = wMap.getOrDefault(c, 0);
            wMap.put(c, count + 1);
            
            if (tMap.containsKey(c) && tMap.get(c).intValue() == wMap.get(c).intValue()) {
                matchedNumOfChars++;
                while (left <= right && matchedNumOfChars == uniqueNumOfChars) {
                    if (minLen > right - left + 1) {
                        leftOfRes = left;
                        rightOfRes = right;
                        minLen = Math.min(minLen, right - left + 1);
                    }
                    
                    char cLeft = s.charAt(left);
                    int cLeftCount = wMap.get(cLeft);
                    wMap.put(cLeft, cLeftCount - 1);
                    
                    if (tMap.containsKey(cLeft) && tMap.get(cLeft).intValue() > wMap.get(cLeft).intValue()) {
                        matchedNumOfChars--;
                    }
                    
                    left++;
                }
            }
            
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftOfRes, rightOfRes + 1);
        
    }
}
