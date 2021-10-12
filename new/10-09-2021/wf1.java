class Solution {
    /*
    "wrt","wrf","er","ett","rftt"
    "wrt" t-> f
    "wrf"
    w->e
    r->t
    e->r
    
    Topological sorting
    
    1: inDegree :
    2: outDegree: 
    
    */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        int[] inDegree = new int[26];
        List<Integer>[] outEdge = new List[26];
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < outEdge.length; i++) {
            outEdge[i] = new ArrayList<>();
        }
        
        //find all characters in words
        for (int i = 0; i <words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
        }
        
        // create edge
        
        /*
        If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
        A[0]: "ab"
        A[1]: "abc"
        */
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                    return "";
                }
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    outEdge[words[i].charAt(j) - 'a'].add(words[i + 1].charAt(j) - 'a');
                    break;
                }
            }
        }
        
        //get inDegree
        for (List<Integer> list : outEdge) {
            for (int i : list) {
                inDegree[i]++;
            }
        }
        
        
        //Topo sorting
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0 && set.contains((char)('a' + i))) {
                queue.offer(i);
            }
        }
        
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append((char)('a' + current));
            for (int i = 0; i < outEdge[current].size(); i++) {
                int index = outEdge[current].get(i);
                inDegree[index]--;
                if (inDegree[index] == 0) {
                    queue.offer(index);
                }
            }
        }
        
        if (sb.length() != set.size()) {
            return "";
        }
        
        return sb.toString();
    }
}