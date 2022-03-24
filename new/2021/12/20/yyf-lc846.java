// Time: O((N+MK)logM)  N是hand长度 M是不同的卡片个数 k是groupSize
// Space: O(M)

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) { // O(N)
            map.put(i, map.getOrDefault(i, 0) + 1); // O(logM)
        }
        
        //TreeMap, an implementation of the SortedMap interface. its keys in sorted order.
        for (int i : map.keySet()) { // O(M)
            int curCount = map.get(i);
            if (curCount > 0) { 
                for (int j = 1; j < groupSize; j++) { // O(K)
                    if (curCount > map.getOrDefault(i + j, 0)) {
                        return false;
                    }
                    map.put(i + j, map.get(i + j) - curCount); // O(logM)
                }
                map.put(i, 0);
            }
        }
        
        return true;
    }
}
