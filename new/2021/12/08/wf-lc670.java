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

--------
    
class Solution {
    /*
    27636
    curr: 6 (9 - 7)
    curr: 1 (9 - 2)
    */
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] numberIndex = new int[10];
        
        for (int i = 0; i < nums.length; i++) {
            numberIndex[nums[i] - '0'] = i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 9; j > nums[i] - '0'; j--) {
                if (numberIndex[j] > i) {
                    char temp = nums[i];
                    nums[i] = nums[numberIndex[j]];
                    nums[numberIndex[j]] = temp;
                    return Integer.valueOf(new String(nums));
                }
            }
        }
        return num;
    }
    
    //1 pass
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIndex = chars.length - 1;
        
        int x = 0;
        int y = 0;
        
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[maxIndex] == chars[i]) { 
                continue;
            }

            if (chars[maxIndex] < chars[i]) {
                maxIndex = i;
            } else {
                x = maxIndex;
                y = i;
            }
        }

        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;

        return Integer.valueOf(new String(chars));
    }
}
