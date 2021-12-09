class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] counts = new int[26];
        int max = 0;
        for (int i = 1; i <= 26; i++) {
            int left = 0;
            int right = 0;
            int unique = 0;
            int haveKOrMore = 0;
            Arrays.fill(counts, 0);
            while (right < s.length()) {
                char curr = s.charAt(right);
                counts[curr - 'a']++;
                if (counts[curr - 'a'] == 1) {
                    unique++;
                }
                if (counts[curr - 'a'] == k) {
                    haveKOrMore++;
                }
                while (unique > i) {
                    curr = s.charAt(left);
                    counts[curr - 'a']--;
                    if (counts[curr - 'a'] == 0) {
                        unique--;
                    }
                    if (counts[curr - 'a'] == k - 1) {
                        haveKOrMore--;
                    }
                    left++;
                }
                if (unique == haveKOrMore) {
                    max = Math.max(max, right - left + 1);
                }
                right++;
            }
        }
        return max;
    }
}
