class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<String> directions = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb, "o");
                    directions.add(sb.toString());
                }
            }
        }
        
        return directions.size();
    }
    
    public void dfs(int i, int j, int[][] grid, StringBuilder sb, String direction) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(direction);
        dfs(i - 1, j, grid, sb, "u");
        dfs(i + 1, j, grid, sb, "d");
        dfs(i, j - 1, grid, sb, "l");
        dfs(i, j + 1, grid, sb, "r");
        sb.append("b");
    }
}

/*
110
011
000
111
010
*/
