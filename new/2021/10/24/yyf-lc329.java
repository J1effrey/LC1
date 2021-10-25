class Solution {
    int ROWS;
    int COLS;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        ROWS = matrix.length;
        COLS = matrix[0].length;
        int[][] cache = new int[ROWS][COLS];
        int maxPathLength = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int currentMaxPath = dfs(i, j, matrix, cache, Integer.MIN_VALUE);
                maxPathLength = Math.max(maxPathLength, currentMaxPath);
            }
        }
        
        return maxPathLength;
        
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] cache, int previous) {
        if (!isValid(i, j) || matrix[i][j] <= previous) {
            return 0;
        }
        
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        int candidate1 = dfs(i + 1, j, matrix, cache, matrix[i][j]);
        int candidate2 = dfs(i - 1, j, matrix, cache, matrix[i][j]);
        int candidate3 = dfs(i, j + 1, matrix, cache, matrix[i][j]);
        int candidate4 = dfs(i, j - 1, matrix, cache, matrix[i][j]);
        
        cache[i][j] = Math.max(candidate1, Math.max(candidate2, Math.max(candidate3, candidate4))) + 1;
        return cache[i][j];
    }
    
    private boolean isValid(int i, int j) {
        return i >= 0 && i < ROWS && j >= 0 && j < COLS;
    }
}
