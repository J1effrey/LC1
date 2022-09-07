class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            int index = arr[ch - 0];
            if (index != -1 && index >= left) {
                left = index + 1;
            }
            arr[ch - 0] = right;
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}

------------------
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c), left);
            }
            map.put(c, i + 1);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
