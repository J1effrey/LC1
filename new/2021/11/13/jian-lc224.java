class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int sign = 1;
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';    
            } else if (c == '+') {
                res += operand * sign;
                operand = 0;
                sign = 1;
            } else if (c == '-') {
                res += operand * sign;
                operand = 0;
                sign = -1;
            } else if (c =='(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += operand * sign;
                res *= stack.pop();
                res += stack.pop();            
                operand = 0;
                sign = 1;
            }
        }
 
        res += operand * sign;
        
        if (!stack.isEmpty()) {
            res *= stack.pop();
        }
        
        return res;
    }
}
