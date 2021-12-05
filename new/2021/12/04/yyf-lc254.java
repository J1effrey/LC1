class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, 2, new ArrayList<>(), res);
        return res;
    }
    
    public void backTrack(int n, int start, List<Integer> temp, List<List<Integer>> res) {
        if (n == 1) {
            if (temp.size() > 1) {
                res.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        
        
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                backTrack(n / i, i, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}