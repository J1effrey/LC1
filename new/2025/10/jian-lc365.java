class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        var visited = new HashSet<String>();
        
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                visited.add(curX + "-" + curY);

                if (curX == target || curY == target || curX + curY == target) {
                    return true;
                }

                // fill x
                if (!visited.contains(x + "-" + curY)) {
                    q.offer(new int[]{x, curY});
                }

                // fill y
                if (!visited.contains(curX + "-" + y)) {
                    q.offer(new int[]{curX, y});
                }

                // empty x
                if (!visited.contains(0 + "-" + curY)) {
                    q.offer(new int[]{0, curY});
                }

                // empty y
                if (!visited.contains(curX + "-" + 0)) {
                    q.offer(new int[]{curX, 0});
                }

                int newX = 0;
                int newY = 0;
                
                // move x to y
                newX = (y - curY) > curX ? 0 : curX - (y - curY) ;
                newY = (y - curY) > curX ? curX + curY  : y;
                if (!visited.contains(newX + "-" + newY)) {
                    q.offer(new int[] {newX, newY});
                }

                // move y to x 
                newX = (x - curX) > curY ? curX + curY : x;
                newY = (x - curX) > curY ? 0 : curY - (x - curX);
                if (!visited.contains(newX + "-" + newY)) {
                    q.offer(new int[] {newX, newY});
                }
            }
        }

        return false;
    }
}
