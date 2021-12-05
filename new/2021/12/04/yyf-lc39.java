class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            temp.add(candidate);
            backTrack(candidates, target - candidate, res, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
}