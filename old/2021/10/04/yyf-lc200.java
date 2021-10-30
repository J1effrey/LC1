class Solution {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private int row;
    private int column;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        row = grid.length;
        column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int res = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, visited, new Point(i,j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, Point p) {
        int x = p.x;
        int y = p.y;
        Stack<Point> stack = new Stack<>();
        stack.push(p);
        
        while (!stack.isEmpty()) {
            Point current = stack.pop();
            if (visited[current.x][current.y]) {
                continue;
            }
            visited[current.x][current.y] = true;
            Point left = getLeft(current);
            Point right = getRight(current);
            Point up = getUp(current);
            Point down = getDown(current);
            
            if (isValid(left)) {
                if (grid[left.x][left.y] == '1' && !visited[left.x][left.y]) {
                    stack.push(left);
                }
            }
            
            if (isValid(right)) {
                if (grid[right.x][right.y] == '1' && !visited[right.x][right.y]) {
                    stack.push(right);
                }
            }
            
            if (isValid(up)) {
                if (grid[up.x][up.y] == '1' && !visited[up.x][up.y]) {
                    stack.push(up);
                }
            }
            
            if (isValid(down)) {
                if (grid[down.x][down.y] == '1' && !visited[down.x][down.y]) {
                    stack.push(down);
                }
            }
        }
    }
    
    private Point getLeft(Point p) {
        return new Point(p.x, p.y - 1);
    }
    
    private Point getRight(Point p) {
        return new Point(p.x, p.y + 1);
    }
    
    private Point getUp(Point p) {
        return new Point(p.x - 1, p.y);
    }
    
    private Point getDown(Point p) {
        return new Point(p.x + 1, p.y);
    }
    
    private boolean isValid(Point p) {
        return p.x >= 0 && p.x < row && p.y >= 0 && p.y < column;
    }
}