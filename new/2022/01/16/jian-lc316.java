// T: O(N)
// S: O(N)

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> seen = new HashSet<>();

        HashMap<Character, Integer> last_occurrence = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) { 
            last_occurrence.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (seen.contains(c)) {
                continue;
            }

            while(!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i){
                seen.remove(stack.pop());
            }
            seen.add(c);
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Character c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
