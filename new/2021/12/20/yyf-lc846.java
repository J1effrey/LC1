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
        for (int i : map.keySet()) { // O(M)
            if (map.get(i) > 0) { 
                for (int j = groupSize - 1; j >= 0; j--) { // O(K)
                    if (map.get(i) > map.getOrDefault(i + j, 0)) {
                        return false;
                    }
                    map.put(i + j, map.get(i + j) - map.get(i)); // O(logM)
                }
            }
        }
        return true;
    }
}
