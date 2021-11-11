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
