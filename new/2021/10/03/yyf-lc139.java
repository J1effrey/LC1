class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}

/*
leetcode
dp[0] true;
dp[1] false; 
dp[2]       "" "le" | dp[1] "e" |  false
dp[3] ""  "lee" | dp[1] "ee" | dp[2] "e"  false
dp[4] ""  "leet"  true;
dp[5]


*/