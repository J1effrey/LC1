class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        
        // "9333" * "0" will "0000" if not add below
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        
        for (int i = num2.length() - 1; i >= 0; i--) {
            char c = num2.charAt(i);
            StringBuilder curTotalAtDigit = multiplyOneChar(num1, c);
            int zeroToAdd = num2.length() - 1 - i;
            for (int j = 0; j < zeroToAdd; j++) {
                curTotalAtDigit.append('0');
            }
            res = plus(res, curTotalAtDigit);
        }

        return res.toString();
    }
    
    public StringBuilder multiplyOneChar(String num1, char c) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int total = (num1.charAt(i) - '0') * (c - '0') + carry;
            int digit = total % 10;
            carry = total / 10;
            sb.append(digit);
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse();
    }
    
    public StringBuilder plus(StringBuilder num1, StringBuilder num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        
        while (p1 >= 0 || p2 >= 0) {
            int v1 = p1 < 0 ? 0 : num1.charAt(p1) - '0';
            int v2 = p2 < 0 ? 0 : num2.charAt(p2) - '0';
            int total = v1 + v2 + carry;
            sb.append(total % 10);
            carry = total / 10;
            p1--;
            p2--;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        
        
        return sb.reverse();
    }
}
