// T:O(2^N)
// S:O(2*sum) 
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int key : map.keySet()) {
                int decreaseKey = key + num;
                temp.put(decreaseKey, temp.getOrDefault(decreaseKey, 0) + map.get(key));
                int increaseKey = key - num;
                temp.put(increaseKey, temp.getOrDefault(increaseKey, 0) + map.get(key));
            }
            map = temp;
        }
        
        return map.getOrDefault(target, 0);
    }
}
