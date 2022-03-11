// O(cols * log rows)
// O(1)

public class Solution {
    public int[] findPeakGrid(int[][] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        
        if (A[0] == null || A[0].length == 0) {
            return null;
        }
        
        
        int rows = A.length;
        int start = 0;
        int end = rows - 1;
        
        while (start + 1 < end) { // O(log rows)
            int mid = start + (end - start) / 2;
            int maxCol = getMaxCol(A, mid); // O(cols)
            
            if (A[mid][maxCol] < A[mid - 1][maxCol]) {
                end = mid;
            } else if (A[mid][maxCol] < A[mid + 1][maxCol]) {
                start = mid;
            } else {
                return new int[]{mid, maxCol};
            }
        }

        int startMaxCol = getMaxCol(A, start);
        int endMaxCol = getMaxCol(A, end);

        return A[start][startMaxCol] > A[end][endMaxCol] ? new int[] {start, startMaxCol} : new int[] {end, endMaxCol};
    }

    private int getMaxCol(int[][] A, int row) {
        int maxCol = 0;
        int cols = A[0].length;

        for (int i = 0; i < cols; i++) {
            if (A[row][i] > A[row][maxCol]) {
                maxCol = i;
            }
        }

        return maxCol;
    }
}
