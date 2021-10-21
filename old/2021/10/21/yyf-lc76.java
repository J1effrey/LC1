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
 
