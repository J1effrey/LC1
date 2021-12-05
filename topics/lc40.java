class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > start && candidates[i] == candidates[i-1]) continue;
            int candidate = candidates[i];
            temp.add(candidate);
            backTrack(candidates, target - candidate, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}