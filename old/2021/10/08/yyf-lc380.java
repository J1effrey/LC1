class RandomizedSet {
    List<Integer> arr;
    Map<Integer, Integer> index;
    Random random;

    public RandomizedSet() {
        arr = new ArrayList<>();
        index = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }
        arr.add(val);
        index.put(val, arr.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }
        int lastNum = arr.get(arr.size() - 1);
        int rmIdx = index.get(val);
        arr.set(rmIdx, lastNum);
        index.remove(val);
        if (rmIdx != arr.size() - 1) {
            index.put(lastNum, rmIdx);
        }
        arr.remove(arr.size() - 1);
        return true;     
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */