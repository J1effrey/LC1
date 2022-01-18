// T: O(m*n*k)
// S: O(m*n)

class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (k >= m + n - 3) {
            return m + n - 2;
        }

        int[][] minK = new int[m][n];
        for (int[] row: minK) {
            Arrays.fill(row, m + n - 3);
        }
        minK[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] g = queue.poll();
                if (g[0] == m - 1 && g[1] == n - 1) {
                    return steps;
                }
                
                for (int[] dir: directions) {
                    int newX = g[0] + dir[0];
                    int newY = g[1] + dir[1];
                    
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    
                    int costOfObstacle = minK[g[0]][g[1]] + grid[newX][newY];
                    if (costOfObstacle > k || minK[newX][newY] <= costOfObstacle) {
                        continue;
                    }
                    minK[newX][newY] = costOfObstacle;
                    queue.offer(new int[] {newX, newY});
                    
                }
            }
            steps++;
        }
        return -1;
    }
}
