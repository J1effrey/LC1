class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int res = 0;
        boolean isNegative = false;
        boolean shouldNextBeDigit = false;
        while (i < s.length()) {
            char cur = s.charAt(i);
            if (!Character.isDigit(cur)) {
                if (Character.isAlphabetic(cur)) {
                return 0;
                }
                if (shouldNextBeDigit) {
                    return 0;
                }
                if (Character.isWhitespace(cur)) {
                    i++;
                    continue;
                }
                if (cur == '+' || cur == '-') {
                    isNegative = cur == '-' ? true : false;
                    i++;
                    shouldNextBeDigit = true;
                    continue;
                }
            }
            
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                int val = Integer.valueOf(s.substring(i, i+1));
                int prev = res;
                res = res * 10 + val;
                if (prev != res / 10) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                i++;
            }
            return isNegative ? -res : res;
        }
        
        return 0;
    }
}
