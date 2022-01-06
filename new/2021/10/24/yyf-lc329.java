// T: O(mn), 
// Each vertex/cell will be calculated once and only once, 
// and each edge will be visited once and only once. The total time complexity is then 
// O(V + E)
// V is the total number of vertices and E is the total number of edges.
// O(V) = O(mn), O(E) = O(4V) = O(4mn)

// S: O(mn), The cache dominates the space complexity

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

/*
class Solution {
    private int rows;
    private int cols;
    private int DIR_NUM = 4;
    private int[] xDir = new int[]{1, -1, 0, 0};
    private int[] yDir = new int[]{0, 0, 1, -1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo));
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] matrix, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int res = 1;
        
        for (int i = 0; i < DIR_NUM; i++) {
            int newX = x + xDir[i];
            int newY = y + yDir[i];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || matrix[newX][newY] <= matrix[x][y]) {
                continue;
            }
            res = Math.max(res, 1 + dfs(newX, newY, matrix, memo));
        }
        
        memo[x][y] = res;
        
        return res;
    }
}

*/
