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
