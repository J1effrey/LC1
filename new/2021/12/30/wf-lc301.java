public class Solution {
 
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> results = new ArrayList<String>();       
        int[] result = getLeftRightCount(s);
        dfs(s, 0, result[0], result[1], results);
        
        return results;
    }
    
    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> results) {
        if(leftCount == 0 && rightCount == 0 && isStringValid(s)) {
            results.add(s);
            return;
        }
        
        for(int i = startIndex; i < s.length(); i++) {
            if(i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if(leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, results);
            }
            
            if(rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, results);
            }
        }
    }
    
    private boolean isStringValid(String s) {
        int[] result = getLeftRightCount(s);
        return result[0] == 0 && result[1] == 0;
    }
    
    private int[] getLeftRightCount(String s) {
        int[] count = new int[]{0, 0};
        for(char c : s.toCharArray()) {
            if(c == '(') {
                count[0]++;
            }    
            if(c == ')') {
                if(count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++;
                }
            }
        }
        return count;
    }
}


// /*
// "()())()"
// )())()
// (())() X
// ())()
// ()()() X
// ()()()
// ()())
// ()())(


public class Solution {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> ans = new ArrayList<String>();
        if (s == null) {
            return ans;
        }
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        // if is found in this level, no need to continue
        boolean found = false;
        queue.offer(s);
        
        while (!queue.isEmpty()) {
            // iterate by level to make sure you get the shortest path
            if (found) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (set.contains(temp)) {
                    continue;
                }
                set.add(temp);
                if (isValid(temp)) {
                    found = true;
                    ans.add(temp);
                } else {
                    for (String word : getNext(temp)) {
                        queue.offer(word);
                    }
                }
            }
        }
        return ans;
        
        
    }
    private boolean isValid(String s){
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                number++;
            } else if (s.charAt(i) == ')') {
                number--;
                if (number < 0) {
                   return false; 
                }
            }
        }
        return number == 0;
    }
    private List<String> getNext(String s){
        List<String> ans = new ArrayList<String>();
        int sum_left = 0;
        int sum_right = 0;
        char remove = '(';
        // find which to remove
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum_left++;
            } else if (s.charAt(i) == ')') {
                sum_right++;
            }
        }
        if (sum_right > sum_left) {
            remove = ')';
        }
        // remove the ')'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == remove) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}
