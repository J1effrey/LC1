class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backTrack(new LinkedHashSet<>(), nums);
        return result;
    }
    
    private void backTrack(Set<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int num : nums) {
            if (temp.add(num)) {
                backTrack(temp, nums);
                temp.remove(num);
            }
            
        }
    }
}