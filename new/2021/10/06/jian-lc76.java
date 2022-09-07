// Time: O(Math.max(S, T))
// Space: O(Math.max(S, T))
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> tCounts = new HashMap<>();
        Map<Character, Integer> sCounts = new HashMap<>();
        int left = 0;
        int right = 0;
        int minDiff = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int formed = 0;
        for (char c : t.toCharArray()) {
            tCounts.put(c, tCounts.getOrDefault(c, 0) + 1);
        }
        int maxFormed = tCounts.keySet().size();
        while (r < s.length()) {
            char ch = s.charAt(r);
            sCounts.put(ch, sCounts.getOrDefault(ch, 0) + 1);
            if (tCounts.containsKey(ch) && sCounts.get(ch).intValue() == tCounts.get(ch).intValue()) {
                formed++;
            }
            while (l <= r && formed == maxFormed) {
                if (r - l < minDiff) {
                    left = l;
                    right = r;
                    minDiff = Math.min(minDiff, r - l);
                }
                char chr = s.charAt(l);
                sCounts.put(chr, sCounts.get(chr) - 1);
                if (tCounts.containsKey(chr) && sCounts.get(chr).intValue() < tCounts.get(chr).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        
        return minDiff == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}
-----------------------------------------------------
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) count++; // valid count
                map.put(c, map.get(c) - 1);
            }
            while (count == t.length()) {
                if (i - left + 1 < minLen) { // 发现更短的
                    minLen = i - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count--;
                }
                left++;
            }      
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}





-----------------------------------------------------
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
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);
            
            if (tMap.containsKey(c) && tMap.get(c).intValue() == wMap.get(c).intValue()) {
                matchedNumOfChars++;
            }
            
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
            
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(leftOfRes, rightOfRes + 1);
        
    }
}
