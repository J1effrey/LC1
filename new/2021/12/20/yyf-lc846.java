class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length == 0 || hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) <= 0) {
                continue;
            }
            for (int j = groupSize - 1; j >= 0; j--) {
                if (map.get(i) > map.getOrDefault(i + j, 0)) {
                    return false;
                }
                map.put(i + j, map.get(i + j) - map.get(i));
            }
        }
        return true;
    }
}

/*
1,2,3,5 2

1 0
2 0
3 1
5 1
*/
