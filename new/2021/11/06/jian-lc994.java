// T: O(m * n)
// S: O(m * n)

class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }   
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer,Integer>>();
        int freshCount = 0;
        int minute = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        
        int[] xDiff = new int[]{1, -1, 0, 0};
        int[] yDiff = new int[]{0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            minute++;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = q.poll();
                int x = cur.getKey();
                int y = cur.getValue();
                
                for (int j = 0; j < 4; j++) {
                    int newX = x + xDiff[j];
                    int newY = y + yDiff[j];
                    if (isValid(newX, newY, m, n) && !visited[newX][newY] && grid[newX][newY] == 1) {
                        freshCount--;
                        if (freshCount == 0) {
                            return minute;
                        }
                        q.offer(new Pair<Integer,Integer>(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
