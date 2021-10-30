class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int currentVal = 0;
        for (int i = 0; i < ss.length; i++) {
            if (Character.isDigit(ss[i])) {
                currentVal = currentVal * 10 + ss[i] - '0';
            }
            
            if (!Character.isDigit(ss[i]) && !Character.isWhitespace(ss[i]) || i == ss.length - 1) {
                if (ss[i] == '(') {
                    int start = i + 1;
                    int end = findFirstMatchBracket(ss, 1, 0, i + 1);
                    currentVal = calculate(s.substring(start, end));
                    i = end - 1;
                    continue;
                } else if (op == '+') {
                    stack.push(currentVal);
                } else if (op == '-') {
                    stack.push(-currentVal);
                } else if (op == '*') {
                    stack.push(stack.pop() * currentVal);
                } else if (op == '/') {
                    stack.push(stack.pop() / currentVal);
                }
                op = ss[i];
                currentVal = 0;
            }
            
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
    
    private int findFirstMatchBracket(char[] ss, int open, int close, int index) {
        while (open > close) {
            if (ss[index] == '(') {
                open++;
            } else if (ss[index] == ')') {
                close++;
            }
            index++;
        }
        
        return index - 1;
    }
}