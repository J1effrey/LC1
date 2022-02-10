// T:O(N^2)
// S:O(N)
class Solution {
    class Union {
        int[] size;
        int[] parent;
        int count;
        public Union(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            } else if (size[rootP] >= size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        
        public int count() {
            return count;
        }
        
        
    }
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        Union un = new Union(m);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    un.union(i, j);
                }
            }
        }
        return un.count();
    }
}

