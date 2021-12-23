class Solution {
    private int n;
    /*
    1 2 3 4 5 6 (7 8 9)  10 11 12 13
              s  e       
    */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
           return 0;
        }
        this.n = matrix.length;
        
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getLessOrEqualCount(mid, matrix) >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (getLessOrEqualCount(start, matrix) >= k) {
            return start;
        }
        
        return end;
    }
    
    private int getLessOrEqualCount(int target, int[][] matrix) {
        int i = n - 1;
        int j = 0;
        int count = 0;
        
        while (i >= 0 && j < n) {
            int num = matrix[i][j];
            if (num <= target) {
                count += (i + 1);
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}


/*
1  5  9 
10 11 13
12 13 15

*/
