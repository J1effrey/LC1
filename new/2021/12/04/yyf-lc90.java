class Solution {
    boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        int levels = nums.length;
        for (int i = 0; i <= levels; i++) {
            backTrack(i, 0, nums, new ArrayList<>(), res);
        }
        return res;
    }
    
    public void backTrack(int level, int start, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == level) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if ((i > 0 && nums[i] == nums[i-1]) && !visited[i - 1]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backTrack(level, i + 1, nums, temp, res);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}