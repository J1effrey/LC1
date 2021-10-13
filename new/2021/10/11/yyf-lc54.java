class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (res.size() < row * col) {
            for (int i = left; i <= right && res.size() < row * col; i++) {
                res.add(matrix[top][i]);
            }
            
            for (int i = top + 1; i <= bottom - 1  && res.size() < row * col; i++) {
                res.add(matrix[i][right]);
            }
            
            for (int i = right; i >= left  && res.size() < row * col; i--) {
                res.add(matrix[bottom][i]);
            }
            
            for (int i = bottom - 1; i >= top + 1 && res.size() < row * col; i--) {
                res.add(matrix[i][left]);
            }
            
            left++;
            right--;
            top++;
            bottom--;
        }
        
        return res;
    }
}