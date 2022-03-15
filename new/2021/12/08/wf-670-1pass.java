// O(n)
// O(1)
class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) { // O(N)
            buckets[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) { // O(N)
            for (int j = 9; j >= 0; j--) { // O(1)
                if (j <= digits[i] - '0') {
                    continue;
                }
                
                int rightMostBiggerIndex = buckets[j];
                if (rightMostBiggerIndex > i) {
                    swap(digits, i, rightMostBiggerIndex);
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        
        return num;
    }
    
    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}
