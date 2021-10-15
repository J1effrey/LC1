class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        } 
        
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        Set<String> words = new HashSet<String>(wordDict);
        
        Queue<Integer> q = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        q.offer(0);
        
        
        while (!q.isEmpty()) {
            int startIndex = q.poll();
            visited.add(startIndex);
            
            for (int i = startIndex + 1; i <= s.length(); i++) {
                String curStr = s.substring(startIndex, i);
                
                if (words.contains(curStr)) {
                    if (i == s.length()) {
                        return true;
                    }
                    
                    if (!visited.contains(i)) {
                        q.offer(i);
                        visited.add(i);
                    }
                    
                }
            }
        }
        
        return false;
    }
}
