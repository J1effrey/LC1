public class Solution {
    class Point {
        int x,y;
        public Point(int _x, int _y) {x=_x;y=_y;}
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m=maze.length;
        int n=maze[0].length;
        if (start[0]==destination[0] && start[1]==destination[1]) {
            return true;
        }
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        LinkedList<Point> list=new LinkedList<>();
        visited[start[0]][start[1]]=true;
        list.offer(new Point(start[0], start[1]));
        
        
        while (!list.isEmpty()) {
            Point p = list.poll();
            int currX = p.x;
            int currY = p.y;
            for (int i=0; i<4; i++) {
                int newX = currX;
                int newY = currY;
                // !!! while !!!
                // !!! while !!!
                // !!! while !!!
                // biggest diff from normal BFS, while
                while (newX >= 0 && newX<m && newY>=0 && newY<n && maze[newX][newY]==0) {
                    newX += dir[i][0];
                    newY += dir[i][1];
                }
                newX -= dir[i][0];
                newY -= dir[i][1];
                if (visited[newX][newY]) {
                    continue;
                }
                visited[newX][newY]=true;
                if (newX == destination[0] && newY==destination[1]) {
                    return true;
                }
                list.offer(new Point(newX, newY));
            }
        }
        return false;
        
    }
}
