// O(N)
// O(N)
class Solution {
    public int minJumps(int[] arr) {
        if(arr.length<=1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            map.putIfAbsent(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                int pop = queue.poll();
                if(pop==arr.length-1) {
                    return count;
                }
                if(pop>0 && visited.add(pop-1)) {
                    queue.add(pop-1);
                }
                if(pop<arr.length-1 && visited.add(pop+1)) {
                    queue.add(pop+1);
                }
                if(map.containsKey(arr[pop])) {
                    for (int index : map.get(arr[pop])) {
                        if(visited.add(index)) {
                            queue.add(index);
                        }
                    }
                    map.remove(arr[pop]); // Since we have already taken all indexes into account, we don't need to traverse them again.
                    // // Consider example: [1,1,1,1,1,1,.....(5000 terms), 11] -> Answer =2;
                }
            }
            count++;
        }
        return -1;
    }
}
