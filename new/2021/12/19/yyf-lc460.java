class RangeModule {
    TreeMap<Integer, Integer> treeMap;
    public RangeModule() {
        treeMap = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        while (treeMap.floorEntry(right) != null) {
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right);
            if (entry.getValue() < left) {
                break;
            }
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            treeMap.remove(entry.getKey());
        }
        treeMap.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) {
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

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */

/*
10 20
10:14 16:20

*/class RangeModule {
    TreeMap<Integer, Integer> treeMap;
    public RangeModule() {
        treeMap = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        while (treeMap.floorEntry(right) != null) {
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(right);
            if (entry.getValue() < left) {
                break;
            }
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            treeMap.remove(entry.getKey());
        }
        treeMap.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(left);
        return entry != null && entry.getValue() >= right;
    }
    
    public void removeRange(int left, int right) {
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

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */

/*
10 20
10:14 16:20

*/
