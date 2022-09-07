class Solution {
    // exact(K) = atMost(k) - atMost(k - 1)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    public int atMost(int[] nums, int k) {
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 发现一个新的不再window里面的数字，还需要不同的k数字-1
            if (map.getOrDefault(nums[i], 0) == 0) k--;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k < 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) k++;
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }
    
}
