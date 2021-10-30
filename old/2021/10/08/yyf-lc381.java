/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


class RandomizedCollection {
    List<Integer> arr;
    Map<Integer, Set<Integer>> index;
    Random random;

    public RandomizedCollection() {
        arr = new ArrayList<>();
        index = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!index.containsKey(val)) {
            index.put(val, new HashSet<>());
        }
        index.get(val).add(arr.size());
        arr.add(val);
        return index.get(val).size() == 1;
        
    }
    
    public boolean remove(int val) {
        if (!index.containsKey(val) || index.get(val).isEmpty()) {
            return false;
        }
        int lastValue = arr.get(arr.size() - 1);
        int removeIndex = index.get(val).iterator().next();
        index.get(lastValue).remove(arr.size() - 1);
        index.get(val).remove(removeIndex);
        arr.set(removeIndex, lastValue);
        if (removeIndex < arr.size() - 1) {
             index.get(lastValue).add(removeIndex);
        }
        arr.remove(arr.size() - 1);
        return true;
        
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}