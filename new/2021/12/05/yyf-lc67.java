// O(max(N,M))
// O(max(N,M))
class Solution {
    public String addBinary(String a, String b) {
       if (a == null || b == null || a.length() == 0 || b.length() == 0) {
           return "";
       } 
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            sb.append((x + y + carry) % 2);
            carry = (x + y + carry) / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
