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
                x = pa[x];
            }
            return x;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return new ArrayList<>();
        }
        
        UnionFind uf = new UnionFind(accounts.size());
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String st = accounts.get(i).get(j);
                if (!map.containsKey(st)) {
                    map.put(st, i);
                } else {
                    int tempIndex = map.get(st);
                    uf.union(tempIndex, i);
                }
            }
        }
        
        Map<Integer, Set<String>> set = new HashMap<>();
        
        for (int i = 0; i < accounts.size(); i++) {
            int parentIndex = uf.find(i);
            
            if (!set.containsKey(parentIndex)) {
                set.put(parentIndex, new HashSet<>());
            }
            
            Set<String> tempSet = set.get(parentIndex);
            
            for (int j = 1; j < accounts.get(i).size(); j++) {
                tempSet.add(accounts.get(i).get(j));
            }
            set.put(parentIndex, tempSet);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (int key: set.keySet()) {
            List<String> list = new ArrayList<>();
            list.addAll(set.get(key));
            Collections.sort(list);
            list.add(0, accounts.get(key).get(0));
            res.add(list);
        }
        
        return res;
    }
}
