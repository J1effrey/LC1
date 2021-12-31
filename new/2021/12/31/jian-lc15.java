class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (nums == null || nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i + 2 < nums.length; i++) { 
            while (i > 0 && nums[i] == nums[i - 1] && i + 2 < nums.length) {
                i++;
            }
            
            int cur = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                if (nums[left] + nums[right] == -cur) {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(cur);
                    l.add(nums[left++]);
                    l.add(nums[right--]);
                    res.add(l);
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] > -cur) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return res;
    }
}
    
    
