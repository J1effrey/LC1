class Solution {
    int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    
    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length 
                       && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (distance[curr[0]][curr[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[curr[0]][curr[1]] + count;
                    pq.offer(new int[]{x, y, distance[x][y]});
                }
            }
        }
        
    }
}
