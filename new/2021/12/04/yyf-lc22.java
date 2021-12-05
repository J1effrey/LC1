class Solution {
     public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backTrack(list, "", 0, 0, n);
        return list; 
    }
    
    private void backTrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max*2) {
            list.add(str);
            return;
        }
        
        if (open < max) {
            backTrack(list, str+"(", open + 1, close, max);
        }
        
        if (close < open) {
            backTrack(list, str+")", open, close + 1, max);
        }
    }
}