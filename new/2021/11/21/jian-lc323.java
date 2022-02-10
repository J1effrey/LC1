// T: O(N) 
// S: O(E) number of edges
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
    public int countComponents(int n, int[][] edges) {
        if (edges == null) {
            return 0;
        }
        Union uf = new Union(n);
        
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        return uf.getCount();
        
    }
}
