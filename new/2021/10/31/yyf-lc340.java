// T: O(NK)
// S: O(K) 

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        
        Map<Character, Integer> appearance = new HashMap<>();
        int distinctNum = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        
        while (right < s.length()) {
            char cur = s.charAt(right);
            appearance.put(cur, appearance.getOrDefault(cur, 0) + 1);
            if (appearance.get(cur) == 1) {
                distinctNum++;
            }
            
            while (distinctNum > k) {
                char pre = s.charAt(left);
                int count = appearance.get(pre);
                appearance.put(pre, count - 1);
                if (appearance.get(pre) == 0) {
                    distinctNum--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        
        return res;
    }
}
// ======================================================================================================
/*
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> appearance = new HashMap<>();
        int unique = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            appearance.put(curr, appearance.getOrDefault(curr, 0) + 1);
            if (appearance.get(curr) == 1) {
                unique++;
            }
            while (unique > k) {
                char prev = s.charAt(left);
                int count = appearance.get(prev);
                if (count == 1) {
                    appearance.remove(prev);
                } else {
                    appearance.put(prev, count - 1);
                }
                
                if (appearance.get(prev) == null) {
                    unique--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
*/
// ======================================================================================================
/*
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int unique = 0;
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) {
                unique++;
            }
            if (unique > k) {
                while (--count[s.charAt(left++)] > 0);
                unique--;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
*/
