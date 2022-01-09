// T: O(8^n)
// S: O(n)
class Solution {
    
    /*
    1 2 3
    4 5 6
    7 8 9
    */
    
    public int numberOfPatterns(int m, int n) {
        // Skip array represents number to skip between two pairs
        int skip[][] = new int[10][10];
        
        // rows
        skip[1][3] = 2;
        skip[3][1] = 2;
        skip[4][6] = 5;
        skip[6][4] = 5;
        skip[7][9] = 8;
        skip[9][7] = 8;
        
        // cols
        skip[1][7] = 4;
        skip[7][1] = 4;
        skip[2][8] = 5;
        skip[8][2] = 5;
        skip[3][9] = 6;
        skip[9][3] = 6;
        
        // dia
        skip[1][9] = 5;
        skip[9][1] = 5;
        
        // anti-dia
        skip[3][7] = 5;
        skip[7][3] = 5;
        
        boolean vis[] = new boolean[10];
        int rst = 0;
        
        // DFS search each length from m to n
        for(int expectedLen = m; expectedLen <= n; expectedLen++) {
            rst += DFS(vis, skip, 1, 1, expectedLen) * 4;    // 1, 3, 7, 9 are symmetric
            rst += DFS(vis, skip, 2, 1, expectedLen) * 4;    // 2, 4, 6, 8 are symmetric
            rst += DFS(vis, skip, 5, 1, expectedLen);        // 5
        }
        return rst;
    }

    public int DFS(boolean vis[], int[][] skip, int cur, int length, int expectedLen) {
        if (length == expectedLen) {
            return 1;
        }
        
        if (length > expectedLen) {
            return 0;
        }
        
        vis[cur] = true;
        int rst = 0;
        
        for (int next = 1; next <= 9; next++) {
            // If vis[i] is not visited and (two numbers are adjacent or skip number is already visited)
            int jump = skip[cur][next];

            if (!vis[next] && (jump == 0 || vis[jump])) {
                rst += DFS(vis, skip, next, length + 1, expectedLen);
            }
        }
        vis[cur] = false;
        return rst;
    }
}
