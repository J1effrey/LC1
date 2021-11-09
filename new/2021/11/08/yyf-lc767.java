class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        
        int offset = 0;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > hash[offset]) {
                offset = i;
            }
        }
        if (hash[offset] > (s.length() + 1) / 2) {
            return "";a
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        while (hash[offset] > 0) {
            res[idx] = (char)('a' + offset);
            idx += 2;
            hash[offset]--;
        }
        
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char)('a' + i);
                idx += 2;
                hash[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}
