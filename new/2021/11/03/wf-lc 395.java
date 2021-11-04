class Solution {
    /*
    n: 1 - total unique letters in s
    */
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        
        for (char ch: s.toCharArray()) {
            set.add(ch);
        }
        
        int res = 0;
        for (int i = 1; i <= set.size(); i++) {
            int start = 0;
            int end = 0;
            int uniqueCount = 0;
            int countK = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            while (end < s.length()) {
                if (uniqueCount <= i) {
                    char cur = s.charAt(end);
                    if (map.getOrDefault(cur, 0) == 0) {
                        uniqueCount++;
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    if (map.get(cur) == k) {
                        countK++;
                    }
                    end++;
                } else {
                    char cur = s.charAt(start);
                    if (map.get(cur) == k) {
                        countK--;
                    }
                    map.put(cur, map.get(cur) - 1);
                    if (map.get(cur) == 0) {
                        uniqueCount--;
                    }
                    start++;
                }
                
                if (uniqueCount == i && countK == i) {
                    res = Math.max(res, end - start);
                }
            }
        }
        return res;
    }
}
