class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n == 0 || dislikes.length == 0 || dislikes[0].length == 0) {
            return true;
        }
        
        int[][] graph = new int[n][n];
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1][dislike[1] - 1] = 1;
            graph[dislike[1] - 1][dislike[0] - 1] = 1;
        }
        int[] group = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == 0 && !dfs(i, group, graph, 1)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int i, int[] group, int[][] graph, int color) {
        group[i] = color;
        for (int j = 0; j < group.length; j++) {
            if (graph[i][j] == 1) {
                if (group[j] == 0 && !dfs(j, group, graph, -color)) {
                    return false;
                }
                if (group[j] == color) {
                    return false;
                }
            }
            
        }
        return true;
    }
}
