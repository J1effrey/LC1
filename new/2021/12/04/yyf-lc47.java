class Solution {
    boolean[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backTrack(new ArrayList<>(), nums, result);
        return result;
    }
    
    public void backTrack(List<Integer> temp, int[] nums, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if ((i > 0 && nums[i] == nums[i-1]) && !visited[i - 1]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backTrack(temp, nums, result);
            temp.remove(temp.size() - 1);  
            visited[i] = false;
        }
    }
}