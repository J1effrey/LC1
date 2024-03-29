class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }
    
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        }
        return y * y * x;
    }
}

-----------------------------------------------------------------------------------------------------------------------
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

---------------------------------------------------------------------------------------------------------------------------------------
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
