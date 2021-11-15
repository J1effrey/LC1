// bfs
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return res;
        }
        
        Set<String> wordSet = new HashSet<String>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return res;
        }
        
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(beginWord));
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundPath = false;
            
            for (int i = 0; i < size; i++) {
                List<String> currPath = queue.poll();
                String lastWord = currPath.get(currPath.size() - 1);
                List<String> neighbors = getNeighbors(lastWord, wordSet);
                
                for (String neigh : neighbors) {
                    List<String> newPath = new ArrayList<String>(currPath);
                    newPath.add(neigh);
                    visited.add(neigh);
                    if (neigh.equals(endWord)) {
                        foundPath = true;
                        res.add(newPath);
                    } else {
                        queue.offer(newPath);
                    }
                }
            }
            
            if (foundPath) {
                break;
            }
            
            for (String s : visited) {
                wordSet.remove(s);
            }        
        }
        
        return res;
    }
    
    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] ch = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                ch[i] = c;
                String str = String.valueOf(ch);
                if (wordSet.contains(str)) {
                    neighbors.add(str);
                }     
            }
        }
        return neighbors;
    }
}

/*
bfs + dfs
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        List<String> solution = new ArrayList<>();
        bfs(beginWord, endWord, neighbors, distance, wordSet);
        dfs(beginWord, endWord, neighbors, distance, wordSet, solution, result);
        return result;
    }
    
    private void bfs(String beginWord, String endWord, Map<String, List<String>> neighbors, Map<String, Integer> distance, Set<String> wordSet) {
        Queue<String> queue = new LinkedList<>();
        int dist = 0;
        queue.offer(beginWord);
        boolean isEnd = false;
        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();    
                List<String> children = getChildren(curr, wordSet);
                for (String child : children) {
                    if (!distance.containsKey(child)) {
                        distance.put(child, dist);
                        if (child.equals(endWord)) {
                            isEnd = true;
                        } else {
                            queue.offer(child);
                        }
                    }
                }
                neighbors.put(curr, children);
                if (isEnd) {
                    break;
                }
            }     
            
        }
    }
    
    private ArrayList<String> getChildren(String node, Set<String> dict) {
      ArrayList<String> res = new ArrayList<String>();
      char chs[] = node.toCharArray();

      for (char ch ='a'; ch <= 'z'; ch++) {
          for (int i = 0; i < chs.length; i++) {
              if (chs[i] == ch) continue;
              char old_ch = chs[i];
              chs[i] = ch;
              if (dict.contains(String.valueOf(chs))) {
                  res.add(String.valueOf(chs));
              }
              chs[i] = old_ch;
          }

      }
      return res;
    }
    
    private void dfs(String cur, String end, Map<String, List<String>> neighbors, Map<String, Integer> distance, Set<String> wordSet, List<String> solution, List<List<String>> res) {
    solution.add(cur);
    if (end.equals(cur)) {
       res.add(new ArrayList<String>(solution));
    } else {
       for (String next : neighbors.get(cur)) {            
            if (distance.get(next) == distance.get(cur) + 1) {
                 dfs(next, end, neighbors, distance, wordSet, solution, res);
            }
        }
    }           
   solution.remove(solution.size() - 1);
}
}
*/
