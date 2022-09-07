// O(26 * N) -> O(N)
// O(26) -> O(1)
class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k < 0) {
            return 0;
        }

        Set<Character> uniqueChars = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            uniqueChars.add(s.charAt(i));
        }
        
        int uniqueCount = uniqueChars.size();
        int res = 0;
 
        for (int i = 1; i <= uniqueCount; i++) {
            int left = 0;
            int right = 0;
            Map<Character, Integer> window = new HashMap<>();
            int uniqueCountMatchedKTimes = 0;
            int nonZeroCount = 0;
            
            while (right < s.length()) {
                if (nonZeroCount <= i) {
                    char cur = s.charAt(right);
                    int curCount = window.getOrDefault(cur, 0);
                    if (curCount == 0) {
                        nonZeroCount++;
                    }
                    window.put(cur, curCount + 1);
                    if (window.get(cur) == k) {
                        uniqueCountMatchedKTimes++;
                    }
                    right++;
                } else {
                    char curLeft = s.charAt(left);
                    int curLeftCount = window.get(curLeft);
                    if (curLeftCount == 1) {
                        nonZeroCount--;
                    }
                    if (curLeftCount == k) {
                        uniqueCountMatchedKTimes--;
                    }
                    window.put(curLeft, window.get(curLeft) - 1);
                    left++;
                }
                
                if (nonZeroCount == i && uniqueCountMatchedKTimes == i) {
                    res = Math.max(res, right - left);
                }
            }
        }
        
        return res;
    }
}

--------------------------------------------------------------------------------
class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int unique = 1; unique < 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            int validCount = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == k) validCount++;
                while (map.keySet().size() > unique) {
                    char leftChar = s.charAt(left);
                    if (map.getOrDefault(leftChar, 0) == k) validCount--;
                    map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }
                int count = map.keySet().size();
                if (count == unique && count == validCount) res = Math.max(i - left + 1, res);
            }
        }
        return res;
    }
}
