// Time: O(N+k), N is the length of num
// Space:O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // remove extra digits
        while (k-- > 0) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (char i : stack) {
            // remove leading zeroes
            if (i == '0' && zero) {
                continue;
            } else {
                zero = false;
            }
            sb.append(i - '0');
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
