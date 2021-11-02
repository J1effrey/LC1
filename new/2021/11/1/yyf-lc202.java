class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        
        return false;
    }
    
    public int squareSum(int n) {
        int res= 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return res;
    }
}
