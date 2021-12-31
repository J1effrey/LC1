// T: O(n), n : length of pushed[]
// S: O(n)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null && popped == null) {
            return true;
        }
        
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        
        if (pushed.length != popped.length) {
            return false;
        }
        
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        
        return stack.isEmpty();
    }
}
