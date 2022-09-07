class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 首先递增当前新cur character
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // 然后把map变成valid符合条件的，不符合的话把左边left的c吐出来
            while (map.size() > 2) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                left++;
            }
            // 现在map符合条件了，统计结果
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
