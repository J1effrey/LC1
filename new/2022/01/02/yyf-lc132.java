// Time: O(N*(N/2+N/2)) => O(N^2)
// Space: O(N)
class Solution {
    public int minCut(String s) {
        int cutsDp[];
        cutsDp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) { // O(N)
            cutsDp[i] = i;
        }
        for (int mid = 0; mid < s.length(); mid++) {  // O(N)
            // check for odd length palindrome around mid index
            findMinimumCuts(mid, mid, cutsDp, s);  // O(N/2)
            // check for even length palindrome around mid index
            findMinimumCuts(mid - 1, mid, cutsDp, s); // O(N/2)

        }
        return cutsDp[s.length() - 1];
    }

    public void findMinimumCuts(int startIndex, int endIndex, int[] cutsDp, String s) {
        int start = startIndex, end = endIndex;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            int newCut = start == 0 ? 0 : cutsDp[start - 1] + 1;
            cutsDp[end] = Math.min(cutsDp[end], newCut);
            start--;
            end++;
        }
    }
}

/*
dp[i] : the minimum cut I can get by the index i
aba
aaaa

dp[i] = i
c bab d
  S E
dp[end] = Math.min(dp[end], dp[start - 1] + 1)
*/
