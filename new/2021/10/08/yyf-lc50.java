class Solution {
    public double myPow(double x, int n) {
        double temp;
        if (n == 0) {
            return 1;
        }
        temp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }    
        return n > 0 ? temp * x * temp : (temp * temp) / x;
    }
}
