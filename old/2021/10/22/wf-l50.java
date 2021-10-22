class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            n = -(n + 1);
            isNegative = true;
        }
        
        double res = 1;
        double temp = x;
        
        while (n != 0) {
            if (n % 2 == 1) {
                res = res * temp;
            }
            temp *= temp;
            n = n / 2;
        }
        
        if (isNegative) {
            res = res * x;
        }
        return res;
    }
}
