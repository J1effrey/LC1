class Solution {
    public int reverse(int x) {
        int res = 0;
        int preRes = 0;
        while (x != 0) {
            int digit = x % 10;
            preRes = res;
            res = res * 10 + digit;
            if (preRes != res / 10) {
                return 0;
            }
            x = x / 10;
        }
        
        return res;
    }
}