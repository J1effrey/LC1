class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String res = null;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && (res == null || (j - i + 1) > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int bestLeft = 0;
        int bestRight = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] singleExpand = expand(s, i, i);
            if (singleExpand[1] - singleExpand[0] > bestRight - bestLeft) {
                bestLeft = singleExpand[0];
                bestRight = singleExpand[1];
            }

            if (i < s.length() - 1) {
                int[] doubleExpand = expand(s, i, i + 1);
                if (doubleExpand[1] - doubleExpand[0] > bestRight - bestLeft) {
                    bestLeft = doubleExpand[0];
                    bestRight = doubleExpand[1];
                }
            }
        }

        return s.substring(bestLeft, bestRight + 1);
    }

    private int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }

            left--;
            right++;
        }

        return new int[]{left + 1, right - 1};
    }
}
