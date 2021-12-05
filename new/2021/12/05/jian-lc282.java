class Solution {
    /*
    This problem has a lot of edge cases to be considered:
        overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
        0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
        a little trick is that we should save the value that is to be multiplied in the next recursion.
        1 + 2 + 3 * 4 ->  (1 + 2 + 3) - 3 + (3 * 4)
    */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, target, 0, 0, 0);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, String num, int target, int pos, long prev, long multi) { 
        if (pos == num.length() && target == prev) {
            res.add(sb.toString());
            return;
        }
        
        for (int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) {
                break;
            }
            
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            
            if (pos == 0) {
                dfs(res, sb.append(curr), num, target, i + 1, curr, curr); 
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, target, i + 1, prev + curr, curr); 
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, target, i + 1, prev - curr, -curr); 
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, target, i + 1, prev - multi + multi * curr, multi * curr); 
                sb.setLength(len);
            }
        }
    }
}
