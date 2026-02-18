class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> lastIdx = new HashMap<>();
        int n = s.length();

        while (right < n) {
            char c = s.charAt(right);

            if (lastIdx.containsKey(c) && lastIdx.get(c) >= left) {
                left = lastIdx.get(c) + 1;
            }

            lastIdx.put(c, right);
            right++;

            res = Math.max(res, right - left);
        }
        return res;
    }
}
