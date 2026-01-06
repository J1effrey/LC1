class UF {
    private int count;
    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    } 

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        parent[rootQ] = rootP;
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public int getCount() {
        return count;
    }
}


class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }       

        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        UF uf = new UF(m * n);
        int zeroCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    zeroCount++;
                    continue;
                }

                // union with its left
                if (i > 0 && grid[i - 1][j] == '1') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }

                // union with its top
                if (j > 0 && grid[i][j - 1] == '1') {
                    uf.union(i * n + j, i * n + (j - 1));
                } 
            }
        }

        return uf.getCount() - zeroCount;

    }
}
