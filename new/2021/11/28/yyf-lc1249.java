class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] result = new char[s.length()];
        Stack<Integer> leftBrackets = new Stack<Integer>();
        
        for (int i = 0; i <= s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                result[i] = c;
                leftBrackets.push(i);
            } else if (c == ')') {
                if (!leftBrackets.empty()) {
                    result[i] = c;
                    leftBrackets.pop();
                } else {
                    result[i] = '.';
                }
            } else {
                result[i] = c;
            }
        }
        
        while (!leftBrackets.isEmpty()) {
            int leftBracketToRemove = leftBrackets.pop();
            result[leftBracketToRemove] = '.';
        }
        
        return convertCharArrayToAnswer(result);
    }
    
    private String convertCharArrayToAnswer(char[] c) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i <= c.length - 1; i++) {
            if (c[i] != '.') {
                sb.append(c[i]);
            }
        }
        
        return sb.toString();
    }
}

/*
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
*/
/*
(( )))

(((  )) 

first step:
1. remove invalid right bracket;  ((  2 2
2. remove remaining left bracket; 0
*/
