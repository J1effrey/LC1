class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum = (runningSum + nums[i]) % k;  
            if (m.containsKey(runningSum)) {
                if (i - m.get(runningSum) >= 2) {
                    return true;
                }
            } else {
                m.put(runningSum, i);
            }
        }
        
        return false;
        
    }
}
