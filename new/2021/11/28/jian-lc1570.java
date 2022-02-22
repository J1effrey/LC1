// T: O(N)
// S: O(N)
class SparseVector {
    Map<Integer, Integer> m = new HashMap<>();
    SparseVector(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            m.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        
        for (Integer index : this.m.keySet()) {
            if (vec.m.containsKey(index)) {
                res += this.m.get(index) * vec.m.get(index);
            }
        }
        
        return res;
    }
}
