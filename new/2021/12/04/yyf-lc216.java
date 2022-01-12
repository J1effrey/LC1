class Solution {
    int maxCount;
    public List<List<Integer>> combinationSum3(int k, int target) {
        maxCount = k;
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int start) {
        if (temp.size() == maxCount && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || temp.size() == maxCount) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            temp.add(candidate);
            backTrack(candidates, target - candidate, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
