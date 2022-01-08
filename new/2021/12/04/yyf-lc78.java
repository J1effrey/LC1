// T: O(N * 2^N)
// S: O(2^n)

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int index) {
        res.add(new ArrayList<Integer>(cur));
        
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(nums, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
            temp.add(nums[i]);
            backTrack(level, i + 1, nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
*/
