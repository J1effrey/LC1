// without set
class Solution {
    class Union {
        int[] parent;
        int[] size;
        int count;
        public Union(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            } 
            
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int zeroCount = 0;
        Union uf = new Union(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    zeroCount++;
                    continue;
                }
                if (i > 0 && grid[i-1][j] == '1') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }
                if (i < m - 1 && grid[i + 1][j] == '1') {
                    uf.union(i * n + j, (i + 1) * n + j);
                }
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * n + j, i * n + j - 1);
                }
                if (j < n - 1 && grid[i][j + 1] == '1') {
                    uf.union(i * n + j, i * n + j + 1);
                }
            }
        }
        return uf.getCount() - zeroCount;
    }
}

/*=============================================================================================================================================================================*/

//  with set
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
                // 重新挂在它爸爸的爸爸也就是爷爷下面 path compression
                pa[x] = pa[pa[x]];
                x = pa[x];
            }
            return x;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        
        UnionFind unionFind = new UnionFind(grid.length * grid[0].length);
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        unionFind.union(i * m + j, (i - 1) * m + j);
                    }
                    if (i <  n - 1 && grid[i + 1][j] == '1') {
                        unionFind.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1] == '1') {
                        unionFind.union(i * m + j, i * m + j + 1);
                    }
                }  
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    set.add(unionFind.find(i * m + j));
                }  
            }
        }
        return set.size();
        
    }
}

