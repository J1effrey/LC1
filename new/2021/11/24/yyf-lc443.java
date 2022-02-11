// T : O(N)
// S : O(1)
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        int right = 0;
        int position = 0;
        
        while (right < chars.length) {
            char currentChar = chars[right];
            int count = 0;
            chars[position++] = currentChar;
            
            while (right < chars.length && chars[right] == currentChar) {
                right++;
                count++;
            }
            
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[position++] = c;
                }   
            }
        }
        
        return position;
    }
}
