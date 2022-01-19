// T: O(N^2)  because substring is O(N)
// S: O(N)
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {    // O(N)
            int twoDigitsVal = Integer.valueOf(s.substring(i-2, i));  // O(N)
            if (s.charAt(i-1) == '0') {
                if (twoDigitsVal > 0 && twoDigitsVal <= 26 ) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '0') {
                    dp[i] = dp[i - 1];
                } else {
                    if (twoDigitsVal > 0 && twoDigitsVal <= 26 ) {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1];
                    }
                    
                }
            }
        }
        
        return dp[s.length()];
        
    }
}


---------------------------------------------------------------------------
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}

// dp[i] dp[2] = 2 dp[0] dp[1] = 1
// not 0 -> dp[i] = dp[i-1]
// (i-1,i) 10 - 26 dp[i] += dp[i-2]  dp[3] = 2 + 1 = 3;
