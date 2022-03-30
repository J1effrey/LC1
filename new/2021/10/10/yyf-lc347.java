//Time:O(N)average
//Space: O(N)
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

=======================

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[]{};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (pq.size() == k) {
                if (map.get(pq.peek()) < map.get(key)) {
                    pq.poll();
                    pq.add(key);
                }
            } else {
                pq.add(key);
            }
            
        }
        
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        
        return res;
    }
}
