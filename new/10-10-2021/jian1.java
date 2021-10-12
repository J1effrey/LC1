class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char curS = s.charAt(i - 1);
                char curP = p.charAt(j - 1);
                
                if (curP == '.' || curS == curP) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (curS != curP) {
                    dp[i][j] = false;
                } if (curP == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char preP = p.charAt(j - 2);
                    
                    if (preP == '.' || preP == curS) {
                        dp[i][j]  = dp[i][j] || dp[i - 1][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
