// linkedHashSet
class LFUCache {
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> list; 
    int minCount = 1;
    int capacity;

    public LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        list = new HashMap<>();
        this.capacity = capacity;
        list.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        list.get(count).remove(key);
        if (!list.containsKey(count + 1)) {
            list.put(count + 1, new LinkedHashSet<>());
        }
        list.get(count + 1).add(key);
        if (count == minCount && list.get(count).size() == 0) {
            minCount  = count + 1;
        }
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int deleteKey = list.get(minCount).iterator().next();
            vals.remove(deleteKey);
            counts.remove(deleteKey);
            list.get(minCount).remove(deleteKey);
        }
        vals.put(key, value);
        counts.put(key, 1);
        minCount = 1;
        list.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
vals
counts
list: count -> LinkedHashSet<> keys
minCount = 1;
*/
