class Solution {
    private int rows;
    private int cols;
    private int[] xDir = new int[] {1, -1, 0, 0};
    private int[] yDir = new int[] {0, 0, 1, -1};
    
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }
        rows = rooms.length;
        cols = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                
                for (int j = 0; j < 4; j++) {
                    int newX = cur[0] + xDir[j];
                    int newY = cur[1] + yDir[j];
                    String visitedStr = newX + "," + newY;
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || rooms[newX][newY] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[newX][newY] = rooms[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
    
}
