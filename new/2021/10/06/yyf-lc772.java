// recursion / best solution
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

----------------------------------------------------------------------------------------------------------------------------------------
// two stack
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.replaceAll(" ", "");
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                num = current - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0;
            } else if (current == '(') {
                ops.push(current);
            } else if (current == ')') {
                while (ops.peek() != '(') {
                    nums.push(helper(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (current == '+' || current == '-' || current == '*' || current == '/') {
                while (!ops.isEmpty() && helper2(ops.peek(), current)) {
                    nums.push(helper(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(current);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(helper(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }
    private int helper(char ops, int a, int b) {
        switch(ops) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return b / a;
        }
        return 0;
    }

    private boolean helper2(char op1, char op2) {
        if (op1 == '(') {
            return false;
        }
        if ((op1 == '-' || op1 == '+') && (op2 == '*' || op2 == '/')) {
            return false;
        }
        return true;
    }
}
