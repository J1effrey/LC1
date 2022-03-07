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
