class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0] == null || routes[0].length == 0) {
            return -1;
        }
        
        if (S == T) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        
        for (int k = 0; k < routes.length; k++) {
            int[] route = routes[k];
            int n = route.length;
            
            for (int i = 0; i < n; i++) {
                int stop = route[i];
                if (!graph.containsKey(stop)) {
                    graph.put(stop, new HashSet<>());
                }
                graph.get(stop).add(k);
            }
        }
        
        if (!graph.containsKey(S) || !graph.containsKey(T)) {
            return -1;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> busTaken = new HashSet<Integer>();
        Set<Integer> stopVisited = new HashSet<Integer>();
        
        q.add(S);
        
        int cnt = 0;
        
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curStop = q.poll(); 
                for (int bus : graph.get(curStop)) {
                    if (busTaken.contains(bus)) {
                        continue; 
                    }
                    
                    busTaken.add(bus); 
                    
                    for (int nextStop : routes[bus]) { 
                        if (nextStop == T) { 
                            return cnt; 
                        }
                        
                        if (stopVisited.contains(nextStop)) {
                            continue;  
                        }
                        
                        q.add(nextStop); 
                        stopVisited.add(nextStop); 
                    }
                }
            }
        }
        
        return -1;
    }
}
