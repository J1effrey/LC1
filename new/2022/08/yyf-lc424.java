class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] count = new int[26];
        int left = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            count[s.charAt(i) - 'A']++;
            while (i - left + 1 - findMax(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    
    public int findMax(int[] count) {
        return Arrays.stream(count).max().getAsInt();
    }
}
