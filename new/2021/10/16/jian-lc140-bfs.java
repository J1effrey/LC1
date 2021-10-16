class Solution {
    class Candidate {
        int index;
        String path;
        public Candidate(int index, String path) {
            this.index = index;
            this.path = path;
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        
        if (s == null || s.length() == 0) {
            return res;
        } 
        
        if (wordDict == null || wordDict.size() == 0) {
            return res;
        }
        
        Set<String> words = new HashSet<String>(wordDict);
        Queue<Candidate> q = new LinkedList<Candidate>();
        
        Map<Integer, Set<String>> visited = new HashMap<Integer, Set<String>>();
        
        q.offer(new Candidate(0, ""));
        Set<String> startSet = new HashSet<String>();
        startSet.add("");
        visited.put(0, startSet);
        
        while (!q.isEmpty()) {
            Candidate cur = q.poll();
            
            for (int i = cur.index + 1; i <= s.length(); i++) {
                String curStr = s.substring(cur.index, i);
                
                if (words.contains(curStr)) {
                    String newStr = "";
                    if (cur.path == "") {
                        newStr = curStr;
                    } else {
                        newStr = cur.path + " " + curStr;
                    }
                    
                    
                    if (i == s.length()) {
                        res.add(newStr);
                    }
                    
                    if (!visited.containsKey(i)) {
                        q.offer(new Candidate(i, newStr));
                        Set<String> newSet = new HashSet<String>();
                        newSet.add(newStr);
                        visited.put(i, newSet);
                    } else {
                        Set<String> set = visited.get(i);
                        if (!set.contains(newStr)) {
                            q.offer(new Candidate(i, newStr));
                            set.add(newStr);
                        }
                    }
                }
            }
        }
        
        return res;
    }
}
