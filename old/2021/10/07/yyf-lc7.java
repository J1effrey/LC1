class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            if (result > 0 && result > (Integer.MAX_VALUE - digit)/10) {
                return 0;
            }

            if (result < 0 && result < (Integer.MIN_VALUE - digit)/10) {
                return 0;
            }

            result = result * 10 + digit;
            x = x / 10;
        }

        return result;
    }
}
