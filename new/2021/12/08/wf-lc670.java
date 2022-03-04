public class Solution {
    /*
        利用单调栈来维护一个严格递减序列
        单调栈里存储的是index，而不是value
        程序分为两步
        第一步找左边需要swap的index，我们希望这个index越小越好
        第二步找右边需要swap的index，该index要大于left，且对应值越大越好，如果值相等，我们希望index越大越好
        时间复杂度为O(n)
    */
    
    public int maximumSwap(int num) {
        String strNum = String.valueOf(num);
        char[] digits = strNum.toCharArray();
        
        Stack<Integer> stack = new Stack<>();
        int left = Integer.MAX_VALUE;
        
        // find left index for swap
        for (int i = 0; i < digits.length; i++) {
            while (!stack.isEmpty() && digits[stack.peek()] < digits[i]) {
                int index = stack.pop();
                left = Math.min(left, index);
            }
            stack.push(i);
        }

        // max swap exists
        if (left != Integer.MAX_VALUE) {
            int right = Integer.MIN_VALUE;
            char max = digits[left];
            
            while (!stack.isEmpty()) {
                int possibleRightIndex = stack.pop();
                if (possibleRightIndex >= left && digits[possibleRightIndex] > max) {
                    right = possibleRightIndex;
                    max = digits[possibleRightIndex];
                }
            }
            
            swap(digits, left, right);
        }
        
        return Integer.parseInt(new String(digits));
    }
    
    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
