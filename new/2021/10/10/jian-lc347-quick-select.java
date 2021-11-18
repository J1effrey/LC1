class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        
        int[] res = new int[k];
        
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        int[] uniqueNums = new int[frequency.size()];
        int index = 0;
        for (Integer num : frequency.keySet()) {
            uniqueNums[index++] = num;
        }
        
        partition(uniqueNums, 0, uniqueNums.length - 1, k - 1, frequency);
        
        for (int i = 0; i < k; i++) {
            res[i] = uniqueNums[i];
        }
        
        return res;
    }
    
    private void partition(int[] nums, int start, int end, int k, Map<Integer, Integer> frequency) {
        if (start == end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        
        while (left <= right) {
            while (left <= right && frequency.get(nums[left]) > frequency.get(pivot)) {
                left++;
            }
            
            while (left <= right && frequency.get(nums[right]) < frequency.get(pivot)) {
                right--;
            }
            
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        
        if (k <= right) {
            partition(nums, start, right, k, frequency);
        }
        
        if (k >= left) {
            partition(nums, left, end, k, frequency);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
