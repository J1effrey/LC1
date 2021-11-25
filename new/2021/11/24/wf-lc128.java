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
        
        public int getMaxSize() {
            int max = 0;
            for (int i = 0; i < sz.length; i++) {
                max = Math.max(max, sz[i]);
            }
            return max;
        }
    }
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(nums.length);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            
            map.put(nums[i], i);
            if (map.containsKey(nums[i] + 1)) {
                unionFind.union(i, map.get(nums[i] + 1));
            }
            
            if (map.containsKey(nums[i] - 1)) {
                unionFind.union(i, map.get(nums[i] - 1));
            }
        }
        
        return unionFind.getMaxSize();
    }
}
