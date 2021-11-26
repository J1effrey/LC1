class Solution {
    public int HALF_OF_MIN = Integer.MIN_VALUE / 2;
    
    public int divide(int dividend, int divisor) {   
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negativeNum = 0;
        if (dividend > 0) {
            dividend = -dividend;
        } else {
            negativeNum++;
        }
        
        if (divisor > 0) {
            divisor = -divisor;
        } else {
            negativeNum++;
        }
        
        
        int quotient = 0;
        
        while (divisor >= dividend) {
            int powerOfTwo = 1;
            int value = divisor;
            
            while (value >= HALF_OF_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            
            quotient += powerOfTwo;
            dividend -= value;
        }
        
        if (negativeNum == 1) {
            return -quotient;
        }
        
        return quotient;
        
    }
}
