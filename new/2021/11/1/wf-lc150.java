class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        
        for (String s : tokens) {
            if (!set.contains(s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            int secondNumber = stack.pop();
            int firstNumber = stack.pop();
            if (s.equals("+")) {
                stack.push(firstNumber + secondNumber);
            } else if (s.equals("-")) {
                stack.push(firstNumber - secondNumber);
            } else if (s.equals("*")) {
                stack.push(firstNumber * secondNumber);
            } else {
                stack.push(firstNumber / secondNumber);
            }
        }
        return stack.pop();
    }
}
