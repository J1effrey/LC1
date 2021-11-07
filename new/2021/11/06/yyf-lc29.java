class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int x = Math.abs(dividend); 
        int y = Math.abs(divisor);
        int result = 0;
        while (x - y >= 0) { 
            int count = 0;
            while (x - (y << 1 << count) > 0) {
                count++;
            }
            result += 1 << count;
            x -= y << count;
        }
        return (dividend <= 0  ^ divisor <= 0) ? -result : result;
        
    }
}
