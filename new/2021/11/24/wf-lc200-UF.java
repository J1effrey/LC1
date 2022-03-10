class UnionFind {
    int[] parents;
    int[] size;
    int count;
    public UnionFind(int n) {
        this.parents = new int[n];
        this.size = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
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
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public int getCount() {
        return this.count;
    }
}

// O(m * n)
// O(m * n)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int zeroCount = 0;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    zeroCount++;
                    continue;
                }
                if (i > 0 && grid[i - 1][j] == '1') {
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
