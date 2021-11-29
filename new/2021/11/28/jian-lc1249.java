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
