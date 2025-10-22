import java.util.Set;

class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if (jug1 + jug2 < target) {
            return false;
        }
    
        Queue<int[]> q = new LinkedList<int[]>();

        q.add(new int[]{0,0});

        var visited = new HashSet<String>();

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (visited.contains(x + " ," + y)) {
                continue;
            }

            if (x + y == target) {
                return true;
            }

            visited.add(x + " ," + y);
            q.add(new int[]{0, y}); // empty first
            q.add(new int[]{x, 0}); // empty second
            q.add(new int[]{jug1, y}); // fill first
            q.add(new int[]{x, jug2}); // fill second
            
            // pour first into second
            q.add(new int[]{x - Math.min(x, jug2 - y), y + Math.min(x, jug2 - y)}); 

            // pour second into first
            q.add(new int[]{x + Math.min(y, jug1 - x), y - Math.min(y, jug1 - x)});
        }

        return false;
    }
}
