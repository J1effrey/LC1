class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        char op = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                
                int cur = Integer.parseInt(s.substring(start, i));
                
                if (op == '+') {
                    stack.push(cur);
                } else if (op == '-') {
                    stack.push(-cur);
                } else if (op == '*') {
                    stack.push(stack.pop() * cur);
                } else if (op == '/') {
                    stack.push(stack.pop() / cur);
                }
                    
                i--;
                
            } else {
                op = c;
            }
        }
        
        int res = 0;
            
        for (int i : stack) {
            res += i;
        }

        return res;
    }
}
