class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int leftCounts = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftCounts++;
                balance++;
            } else if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        
        int validCountOfLeftBrackets = leftCounts - balance;
        StringBuilder res = new StringBuilder();
        for (char c : sb.toString().toCharArray()) {
            if (c == '(') {
                validCountOfLeftBrackets--;
                if (validCountOfLeftBrackets < 0) {
                    continue;
                }
            }
            res.append(c);
        }
        
        return res.toString();
    }
}
/*
(( )))

(((  )) 

first step:
1. remove invalid right bracket;  ((  2 2
2. remove remaining left bracket; 0
*/
