class Solution {
    class UnionFind {
        private int[] pa;
        private int[] sz;
        public UnionFind(int N) {
            pa = new int[N];
            sz = new int[N];
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
            } else {
                pa[qParent] = pParent;
                sz[pParent] += sz[qParent];
            }
        }
        public int find(int x) {
            while (x != pa[x]) {
                pa[x] = pa[pa[x]];
                x = pa[x];
            }
            return x;
        }
    }
    
    int rows;
    int cols;
    int[] x_Dir = new int[]{0, 0, -1, 1};
    int[] y_Dir = new int[]{1, -1, 0, 0};
    
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        
        // union current map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                
                int cur = getIndexInUF(i, j);
                for (int k = 0; k < 4; k++) {
                    int newX = i + x_Dir[k];
                    int newY = j + y_Dir[k];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] == 0) {
                        continue;
                    }
                    uf.union(cur, getIndexInUF(newX, newY));
                }
            }
        }
        
        // remember current biggest size
        for (int curSize: uf.sz) {
            res = Math.max(res, curSize);
        }
        
        // flip water to land
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                Set<Integer> visitedParents = new HashSet<>();
                int possibleRes = 1;
                for (int k = 0; k < 4; k++) {
                    int newX = i + x_Dir[k];
                    int newY = j + y_Dir[k];
                    if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || grid[newX][newY] == 0) {
                        continue;
                    }
                    int accessorOfNew = uf.find(getIndexInUF(newX, newY));
                    if (!visitedParents.contains(accessorOfNew)) {
                        visitedParents.add(accessorOfNew);
                        possibleRes += uf.sz[accessorOfNew];
                    }
                }
                res = Math.max(res, possibleRes);
            }
        }

        return res;
    }
    
    private int getIndexInUF(int x, int y) {
        return x * rows + y;
    }
}
