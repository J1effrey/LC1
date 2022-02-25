// T:O(N)
// S:O(N)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (!map.containsKey(remainder)) {
                map.put(remainder, i);
            } else {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

// m * k + y
// n * k + y
// (m - n) * k
