// T: O(N * N)
// S: O(N)

class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int count;
        public UnionFind(int n) {
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
    
    public int removeStones(int[][] stones) {
        int rows = stones.length;
        
        UnionFind uf = new UnionFind(rows);
        
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                int[] first = stones[i];
                int[] second = stones[j];
                if (first[0] == second[0] || first[1] == second[1]) {
                    uf.union(i, j);
                }
            }
        }
        
        return rows - uf.getCount();
    }
}
