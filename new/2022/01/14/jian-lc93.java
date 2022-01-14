// T: O( C n-1 3) , (n-1)(n-2)(n-3) / 6, n**3
// S: O(n)
// n is length of s

// If one already put a dot that leaves only 3 possibilities for the next dot to be placed : after one digit, after two digits, or after three digits. The first dot has only 3 available slots as well.

// That propagates constraints and helps to reduce a number of combinations to consider. Instead of // 990990 combinations it's enough to check just 3 \times 3 \times 3 = 27  3×3×3=27

// Space complexity : constant space to keep the solutions, not more than 19 valid IP addresses.

class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        helper(res,new StringBuilder(),s,0,0);
        return res;
    }
    
    
    public void helper(List<String> res, StringBuilder temp, String s,int start, int count){
        if (start == s.length() && count == 4) {
            res.add(temp.toString());
            return;
        }
            
        if (count >= 4) {
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            String curr = s.substring(start,i+1);
            int value = Integer.parseInt(curr);
            
            // leading 0
            if (curr.length()>1 && curr.charAt(0)=='0') {
                return;
            }
            
            // out of range
            if (value > 255 || value < 0) {
                return;
            }
            
            StringBuilder rollback = new StringBuilder(temp);
            temp.append(s.substring(start,i + 1));
            
            if (count < 3) {
                temp.append(".");
            }

            helper(res, temp, s, i + 1, count + 1);
            
            temp = rollback;
        }
    }
}
