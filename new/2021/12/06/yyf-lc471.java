class Solution {
    Map<String, String> map = new HashMap<>();
    public String encode(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() <= 4) {
            return s;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        String res = s;
        for (int i = s.length() / 2; i < s.length(); i++) {
            String pattern = s.substring(i);
            int count = countPatterns(s, pattern);
            if (count == -1) {
                continue;
            }
            String candidate = count + "[" + encode(pattern) + "]";
            if (candidate.length() < res.length()) {
                res = candidate;
            }
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            String candidate = encode(left) + encode(right);
            if (candidate.length() < res.length()) {
                res = candidate;
            }
        }
        map.put(s, res);
        return res;
    }
    
    public int countPatterns(String s, String p) {
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.substring(i).startsWith(p)) {
                i += p.length();
                count++;
            } else {
                return -1;
            }
        }
        return count * p.length() == s.length() ? count : -1;
    }
}

/*
s.length() <= 4 return s;
aabcaabc
aabc aabc
2[aabc]
*/
