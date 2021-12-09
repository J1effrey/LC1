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
