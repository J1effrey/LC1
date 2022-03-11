// T:O(MN)
// S:O(1)
class Solution {
    public int countSquares(int[][] A) {
        /*
        dp[i][j] means the size of biggest square with A[i][j] as bottom-right corner.
        dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.
        */
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                res += A[i][j];
            }
        }
        return res;
    }
}
