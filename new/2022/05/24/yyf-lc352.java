class SummaryRanges {
    
    TreeSet<int[]> set;
    public SummaryRanges() {
        set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }
    
    public void addNum(int val) {
        int[] interval = new int[]{val, val};
        if (set.contains(interval)) {
            return;
        }
        int[] low = set.lower(interval);
        int[] high = set.higher(interval);
        // When we want to merge with right side, right side can't contains interval!!!
        // why we don't need to determine low ? -----> low's start point is strictly smaller than val, because interval={val, val} 
        if (high != null && high[0] == val) {
            return;
        }
        // can merge with left and right side
        if (low != null && low[1] + 1 == val && 
            high != null && val + 1 == high[0]) {
            low[1] = high[1];
            set.remove(high);
        }
        // can merge with left side
        // why >=?   ---->  when we use lower, we can only find the start that is lower than val, the end can be larger!!!
        else if (low != null && low[1] + 1 >= val) {
            low[1] = Math.max(low[1], val);
        } 
        // can merge with right side
        else if (high != null && val + 1 == high[0]) {
            high[0] = val;
        } 
        // cannot merge with either side
        else {
            set.add(interval);
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> res = new ArrayList<>();
        for (int[] interval : set) {
            res.add(interval);
        }
        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
