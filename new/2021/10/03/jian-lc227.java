// O(N)
// O(N)
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> operands = new Stack<>();
        
        int operand = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (Character.isDigit(cur)) {
                operand = operand * 10 + cur - '0';
            }
            
            if (i == s.length() - 1 || !Character.isDigit(cur) && cur != ' ') {
                switch (sign) {
                    case '+':
                        operands.push(operand);
                        break;
                    case '-':
                        operands.push(-operand);
                        break;
                    case '*':
                        operands.push(operands.pop() * operand);
                        break;
                    case '/':
                        operands.push(operands.pop() / operand);
                        break;
                }
                operand = 0;
                sign = cur;
            }
        }
        
        int res = 0;
        
        while (!operands.isEmpty()) {
            res += operands.pop();
        }
        
        return res;
    }
}
