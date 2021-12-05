class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, k, new ArrayList<>(), res, 1);
        return res;
    }
    
    public void backTrack(int n, int k, List<Integer> temp, List<List<Integer>> res, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backTrack(n, k, temp, res, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}