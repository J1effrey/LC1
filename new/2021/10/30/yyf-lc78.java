class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    int level;
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        n = nums.length;
        for (level = 0; level < n + 1; level++) {
            backtrack(0, new ArrayList(), nums);
        }
        return result;
    }
    
    public void backtrack(int first, List<Integer> curr, int[] nums){
        if (curr.size() == level) {
            result.add(new ArrayList(curr));
            return;
        }
        
        for (int i = first; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
