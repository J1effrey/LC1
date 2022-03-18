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
    int[] X_DIR = new int[]{1, -1, 0, 0};
    int[] Y_DIR = new int[]{0, 0, 1, -1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int zeroCount = 0;
        
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    zeroCount++;
                    continue;
                }
                
                for (int k = 0; k < 4; k++) {
                    int newX = i + X_DIR[k];
                    int newY = j + Y_DIR[k];
                    
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX][newY] == '0') {
                        continue;
                    }
                    
                    uf.union(i * col + j, newX * col + newY);
                }
            }
        }
        return uf.getCount() - zeroCount;
    }
}
