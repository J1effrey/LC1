// BFS
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

// =============================-===============================================================================
// DFS
// O(L/M*N)
// N 是字典单词个数
// M是最短单词长度
// L是单词长度
class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.equals("")) {
            return res;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            res.add(s);
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            String prefix =  s.substring(0, i + 1);
            String suffix = s.substring(i + 1);
            if (wordDict.contains(prefix)) {
                List<String> temp = wordBreak(suffix, wordDict);
                if (temp.size() != 0) {
                    for (String str : temp) {
                        res.add(prefix + " " + str);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
                                                        
    }
}
