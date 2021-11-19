package com.yyf.leetcode;

public class Square4BigNumbers {

        public static void main(String[] args) {
            System.out.println("Hello World!");
            System.out.println(squareForBigNumber("999999999999999999"));
        }

        // Math.power(378132088094988012730173071, 2)
        // cannot use big Integer
        // only contains digits, always positive
        // no 0 leading
        public static String squareForBigNumber(String num) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            int len = num.length();
            for (int i = 1; i < 2 * len; i++) {
                int val = cal(num, i) + carry;
                sb.append(val % 10);
                carry = val / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }

    private static int cal(String num, int i) {
        int left = i <= num.length() ? i - 1 : num.length() - 1;
        int right = i <= num.length() ? 0 : i - num.length();
        int res = 0;
        while (left >= right) {
            res += Character.getNumericValue(num.charAt(left)) * Character.getNumericValue(num.charAt(i -left - 1));
            left--;
        }
        return res;
    }
}
