// T: O(row * col)
// S: O(row * col)
class Solution {
    class UnionFind {
        private int[] pa;
        private int[] sz;
        private int maxSize;
        
        public UnionFind(int N) {
            pa = new int[N];
            sz = new int[N];
            maxSize = 1;
            
            for (int i = 0; i < N; i++) {
                pa[i] = i;
                sz[i] = 1;
            }
        }
        
        public void union(int p, int q) {
            int pParent = find(p);
            int qParent = find(q);
            if (pParent == qParent) {
                return;
            }
            if (sz[pParent] < sz[qParent]) {
                pa[pParent] = qParent;
                sz[qParent] += sz[pParent];
                maxSize = Math.max(maxSize, sz[qParent]);
            } else {
                pa[qParent] = pParent;
                sz[pParent] += sz[qParent];
                maxSize = Math.max(maxSize, sz[pParent]);
            }
        }
        
        public int find(int x) {
            while (x != pa[x]) {
                pa[x] = pa[pa[x]];
                x = pa[x];
            }
            return x;
        }
        
        public int getMaxSize() {
            return maxSize;
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind unionFind = new UnionFind(grid.length * grid[0].length);
        int n = grid.length;
        int m = grid[0].length;
        boolean foundLand = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    foundLand = true;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        unionFind.union(i * m + j, (i - 1) * m + j);
                    }
                    if (i <  n - 1 && grid[i + 1][j] == 1) {
                        unionFind.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        unionFind.union(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1] == 1) {
                        unionFind.union(i * m + j, i * m + j + 1);
                    }
                }  
            }
        }
        return foundLand ? unionFind.getMaxSize() : 0;
    }
}
