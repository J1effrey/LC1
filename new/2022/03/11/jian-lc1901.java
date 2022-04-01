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

----------------------------------------------------------------------------------------------------------------
public class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int low = 0, high = m-1, maxIdx = 0;
        while(low < high) {
            int mid = (low + high) / 2;
            maxIdx = findMax(mat[mid]);
            if(mat[mid][maxIdx] < mat[mid+1][maxIdx]) {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
		maxIdx = findMax(mat[low]);
        return new int[]{low, maxIdx};
    }
    
    private int findMax(int[] arr) {
        int index = 0, max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
