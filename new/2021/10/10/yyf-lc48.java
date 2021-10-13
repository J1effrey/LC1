class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int n = matrix.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            // rotate my outer layer (right - left) times
            for (int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;
                int temp = matrix[top][left + i];
                // move bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left];
                // move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];
                // move up right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];
                // move top left to  top right
                matrix[top + i][right] = temp;
            }
            left++;
            right--;
        }
    }
}