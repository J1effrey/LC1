// T: O(N)
// S: O(N)
class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) { 
            counts[S.charAt(i) - 'a']++;
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                q.offer(new int[] {i, counts[i]}); // add char counts to priority queue
            }
        }
        
        // !!!  prev to prevent two consective same chars !!!
        // if a 4 b3
        // after sb.append('a');
        // becomes a 3 b3
        // prev stores a 3 away, next time pq only poll  b 3
        int[] prev = new int[] {-1, 0};
        StringBuilder sb = new StringBuilder();
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (prev[1] > 0) {
                q.offer(prev);
            }

            sb.append((char)(cur[0] + 'a'));
            cur[1]--; 
            prev = cur; 
        }

        return (q.isEmpty() && prev[1] > 0) ? "" : sb.toString();
    }
}

===

class Solution {
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        
        int offset = 0;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > hash[offset]) {
                offset = i;
            }
        }
        if (hash[offset] > (s.length() + 1) / 2) {
            return "";a
        }
        
        char[] res = new char[s.length()];
        int idx = 0;
        while (hash[offset] > 0) {
            res[idx] = (char)('a' + offset);
            idx += 2;
            hash[offset]--;
        }
        
        for (int i = 0; i < 26; i++) {
            while (hash[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char)('a' + i);
                idx += 2;
                hash[i]--;
            }
        }
        
        return String.valueOf(res);
    }
}
