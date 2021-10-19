class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        
        return dfs(s, p, 0, 0, memo, visited);
    }
    private boolean dfs(String s, String p, int sIndex, int pIndex, boolean[][] memo, boolean[][] visited) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (sIndex == s.length()) {
            return helper(pIndex, p);
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        char currS = s.charAt(sIndex);
        char currP = p.charAt(pIndex);
        boolean res;
        
        if (currP == '*') {
            res = dfs(s, p, sIndex + 1, pIndex, memo, visited) || dfs(s, p, sIndex, pIndex + 1, memo, visited);
        } else {
            if (currP == '?' || currS == currP) {
                res = dfs(s, p, sIndex + 1, pIndex + 1, memo, visited);
            } else {
                res = false;
            }
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = res;
        return res;
    }
    
    private boolean helper(int pIndex, String p) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
