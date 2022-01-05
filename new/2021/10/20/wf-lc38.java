// T: O(n * avg(length of temp))
// S: O(n * avg(length of temp))

class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        
        String res = "1";
        
        if (n == 1) {
            return res;
        }
        
        while (n > 1) {
            res = helper(res);
            n--;
        }
        return res;
    }
    private String helper(String input) {
        int count = 1;
        int start = 1;
        char previous = input.charAt(0);
        String res = "";
        while (start < input.length()) {
            char current = input.charAt(start);
            if (current == previous) {
                count++;
            } else {
                res = res + count + previous;
                previous = current;
                count = 1;
            }
            start++;
        }
        res = res + count + previous;
        return res;
    }
}
