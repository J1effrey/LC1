class SparseVector {
    List<int[]> list;
    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (vec.list.size() > list.size()) return vec.dotProduct(this);
        int dotProduct = 0;
        for (int i = 0; i < vec.list.size(); i++) {
            int index = vec.list.get(i)[0];
            int value = vec.list.get(i)[1];
            dotProduct += value * binarySearch(index, 0, list.size() - 1);
        }
        return dotProduct;
    }
    
    public int binarySearch(int index, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[0] == index) return list.get(mid)[1];
            else if (list.get(mid)[0] < index) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
