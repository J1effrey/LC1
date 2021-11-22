class Solution {
    class UnionFind {
        private int[] parents;
        private int[] length;
        
        public UnionFind(int size) {
            parents = new int[size];
            length = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
                length[i] = 1;
            }
        }
        
        public void union(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) {
                return;
            }
            
            if (length[aParent] < length[bParent]) {
                parents[aParent] = bParent;
            } else if (length[aParent] > length[bParent]) {
                parents[bParent] = aParent;
            } else {
                parents[aParent] = bParent;
                length[bParent] += 1;
            }
        }
        
        public int find(int a) {
            while (a != parents[a]) {
                a = parents[a];
            }
            return a;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 || edges[0] == null || edges[0].length == 0) {
            return n;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        
        Set<Integer> parents = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) {
            parents.add(uf.find(i));
        }
        
        return parents.size();
        
    }
}
