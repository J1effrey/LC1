class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        String s = "";
        
        backTrack(n, 0, 0, s);
        return res;
    }
    
    private void backTrack(int max, int open, int close, String s) {
        if (open == close && open == max) {
            res.add(s);
            return;
        }
        
        if (open < max) {
            backTrack(max, open + 1, close, s+"(");
        }
        
        if (close < open) {
            backTrack(max, open, close + 1, s+")");
        }
    }
}
