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
        
        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return false;
            } 
            
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
            return true;
        }
        
        public int getCount() {
            return this.count;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        
        if (edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            return n == 1;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            
            if (!uf.union(start, end)) {
                return false;
            };
        }
        
        return uf.getCount() == 1;
    }
}
