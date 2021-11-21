class Solution {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        
        x = Math.abs(x);
        y = Math.abs(y);
        int[] xDir = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
        int[] yDir = new int[]{1, -1, 1, -1, 2, -2, 2, -2};
        int step = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0, 0});
        Set<String> visited = new HashSet<String>();
        visited.add("0,0");
        
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int j = 0; j < xDir.length; j++) {
                    int newX = cur[0] + xDir[j];
                    int newY = cur[1] + yDir[j];
                    if (newX == x && newY == y) {
                        return step;
                    }
                    String visitedStr = newX + "," + newY;
                    if (newX < -1 || newY < -1 || visited.contains(visitedStr)) {
                        continue;
                    }
                    q.offer(new int[]{newX, newY});
                    visited.add(visitedStr);
                }
            }
        }    
        
        return step;
    }
}
