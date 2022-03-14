class RangeModule {
    // sorted by left
    
    // queryRange: 
    // binary search: left in which zone, 
        // find last smaller than or equal left 
        //find first bigger than left
    // intervals arrayList. sorted
    
    
    // addRange : 
    //   query range
    //   merge intervals
    
    
    // removeRange
    // query -> true
    //   bigger interval -> split into smaller intervals
    TreeMap<Integer, Integer> treeMap;
    public RangeModule() {
        treeMap = new TreeMap<>();
    }
    
    public void addRange(int left, int right) { // O(N logN)
        while (treeMap.floorEntry(right) != null) { // O(N)
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right); // O(logN)
            
            // floorRight, entry.getValue()  <  left, right
            // no overlap
            if (entry.getValue() < left) {
                break;
            }
            
            // floorRight, left <= entry.getValue(), right
            // merge
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            treeMap.remove(entry.getKey());
        }
        treeMap.put(left, right);
    }
    
    public boolean queryRange(int left, int right) { // O(logN)
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) { // O(N logN)
        addRange(left, right);
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(left);
        
        treeMap.remove(entry.getKey());
        if (entry.getKey() < left) {
            treeMap.put(entry.getKey(), left);
        }
        
        if (entry.getValue() > right) {
            treeMap.put(right, entry.getValue());
        }
    }
}
