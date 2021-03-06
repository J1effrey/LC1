// O(s1 * s2)
class Solution {
    public String minWindow(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return "";
        }
        
        String res = "";
        int minLen = s1.length() + 1;
        int left = 0;
        int right = 0;
        int s2Index = 0;
        
        while (right < s1.length()) {
            char c = s1.charAt(right);
            
            if (c == s2.charAt(s2Index)) {
                s2Index++;
            }
            
            if (s2Index == s2.length()) {
                left = right;
                while (s2Index > 0) {
                    // 后面的要 前面的不要
                    // 例如 s1:abced  s2:bcd => bced最优
                    char cLeft = s1.charAt(left);
                    if (cLeft == s2.charAt(s2Index - 1)) {
                        s2Index--;
                    }
                    left--;
                }
                
                if (right - left < minLen) {
                    minLen = right - left;
                    res = s1.substring(left + 1, right + 1);
                }
                
                right = left + 2;
            }
            right++;
        }
        
        return res;
    }
}

------------------------------------------------------------------
class Solution {
    public String minWindow(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        int right = 0;
        int left = 0;
        int index = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";
        while (right < s1.length()) {
            index = 0;
            while (right < s1.length()) {
                if (s1.charAt(right) == s2.charAt(index)) {
                    index++;
                }
                if (index == s2.length()) {
                    break;
                }
                right++;
            }
            if (right == s1.length()) {
                break;
            }
            left = right;
            index--;
            while (index >= 0) {
                if (s1.charAt(left) == s2.charAt(index)) {
                    index--;
                }
                if (index < 0) {
                    break;
                }
                left--;
            }
            if (right - left + 1 < minLen) {
                minLen = right -left + 1;
                result = s1.substring(left, right + 1);
            }
            right = left + 1;
        }
        return result;
    }
}

/*
abcdebdde
bde

abcdaede
*/
