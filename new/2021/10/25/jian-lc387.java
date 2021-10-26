class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            int count = m.getOrDefault(s.charAt(i), 0);
            m.put(s.charAt(i), count + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (m.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}
