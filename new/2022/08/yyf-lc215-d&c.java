class Solution {
    public int findKthLargest(int[] nums, int k) {
        // shuffle(nums);
        divide(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }
    
    private void divide(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int position = conquer(nums, left, right);
        if (position == nums.length - k)  {
            return;
        } else if (position < nums.length - k) {
            divide(nums, position + 1, right, k);
        } else {
            divide(nums, left, position - 1, k);
        }
    }
    
    // 基本思路就是把最右边当作pivot，然后左边比pivot小的都放在墙的左边
    // 然后把墙和pivot互换位置，pivot就在正确的排序位置上
    // refer lc-283
    private int conquer(int[] nums, int left, int right) {
        int pivot = nums[right];
        int wall = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1); // [i, j)
            swap(nums, i, j);
        }
    }
}
