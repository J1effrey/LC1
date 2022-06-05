class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int totalNumber = 1 << nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int mask = 0; mask < totalNumber; mask++) {
            List<Integer> set = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            res.add(set);
        }
        return res;
    }
}
