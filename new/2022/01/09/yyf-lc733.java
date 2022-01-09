// T: O(rc)
// S: O(rc)
class Solution {
    int[] X_DIR = {0, 1, 0, -1};
    int[] Y_DIR = {1, 0, -1, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image; // same color -> no need to replace
        }
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (!q.isEmpty()) {
            int[] top = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = top[0] + X_DIR[i];
                int nc = top[1] + Y_DIR[i];
                if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldColor) {
                    continue;
                }
                image[nr][nc] = newColor; // also mean we marked it as visited!
                q.offer(new int[]{nr, nc});
            }
        }
        return image;
    }
}
