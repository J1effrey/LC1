class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        
        dfs(nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void dfs(int[] nums, List<Integer> temp, int position) {
        res.add(new ArrayList<>(temp));
        if (position >= nums.length) {
            return;
        }
        
        for (int i = position; i < nums.length; i++) {
            if (i > position && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

===

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
