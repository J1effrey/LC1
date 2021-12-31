class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.offer(c);
        }
        return helper(q);
    }
    
    public int helper(Queue<Character> q) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        char operation = '+';
        
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';    
            }
            
            if (c == '(') {
                operand = helper(q);
            }
            
            if (!Character.isDigit(c) || q.isEmpty()) {
                if (operation == '+') {
                    stack.push(operand);
                } else if (operation == '-') {
                    stack.push(-operand);
                } else if (operation == '*') {
                    stack.push(stack.pop() * operand);
                } else if (operation == '/') {
                    stack.push(stack.pop() / operand);
                }
                operand = 0;
                operation = c;
            }
            
            if (c == ')') {
                break;
            }
        }
        
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
}

/*

TDD : Test Driven Development

"6-4/2"
"2*(5+5*2)/3+(6/2+8)"
*/
