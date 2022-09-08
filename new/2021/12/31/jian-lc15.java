// T: O(NlogN + N^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int pivot = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -pivot) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    continue;
                } 
                
                if (nums[left] + nums[right] > -pivot) {
                    right--;
                    continue;
                } 
                
                left++;
            }
        }
        return res;
    }
}

---------------------------------
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] + nums[i] == 0) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (nums[start] + nums[end] + nums[i] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}

    
    
