class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }
        
        int maxLen = 1;
        for (int num : nums) {
            int low = num - 1;
            int high = num + 1;
            uniqueNums.remove(num);
            while (uniqueNums.contains(low)) {
                uniqueNums.remove(low);
                low--;
            }
            while (uniqueNums.contains(high)) {
                uniqueNums.remove(high);
                high++;
            }
            maxLen = Math.max(maxLen, high - low - 1);

        }
        return maxLen;
    }
}
