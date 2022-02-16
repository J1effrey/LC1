/*
I think the complexity is O(Nsqrt(N)).
Assume the number of steps we can take at a position, which is the size of the inner loop, is K. Worst case is when we have one stone at each possible position, creating a lot of possible jumpsizes. To get a jumpsize K, we must at least have stone [0, 1, 3, 6, 10, ..., a_K], i.e. we always take the maximal step at each stone so that at the K-th term of this array, we can take any jumpsize between 1 to K. This array satisfies a_n - a_(n-1) = a_(n-1) - a_(n-2), from which we can easily derive a_K = K(K-1) / 2. Hence, at a position x, the number of jumpsizes we can get is sqrt(x) and the overall complexity is O(N*sqrt(N))
Ref and math proof: https://math.stackexchange.com/questions/422559/what-is-sum-limits-i-1n-sqrt-i.
*/

class Solution {
    class Jump {
        int position;
        int lastStep;
        public Jump(int position, int lastStep) {
            this.position = position;
            this.lastStep = lastStep;
        }
    }
    
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }

        Set<Integer> stonesAvaliable = new HashSet<>();
        
        for (Integer i : stones) {
            stonesAvaliable.add(i);
        }
        
        int target = stones[stones.length - 1];
        
        Queue<Jump> queue = new LinkedList();
        queue.offer(new Jump(0, 0));
        Set<String> visited = new HashSet();
        visited.add(0 + "-" + 0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Jump jump = queue.poll();
                
                if (jump.position == target) {
                    return true;
                }
                
                for (int j = -1; j <= 1; j++) {
                    int nextStep = jump.lastStep + j;
                    int nextPosition = jump.position + nextStep;
                    
                    if (nextStep < 1) { 
                        continue;
                    }
                    
                    if (!stonesAvaliable.contains(nextPosition)) {
                        continue;
                    }
                    
                    String visitedStr = nextPosition + "-" + nextStep;
                    if (visited.contains(visitedStr)){
                        continue;
                    }
                    
                    queue.offer(new Jump(nextPosition, nextStep));
                    visited.add(visitedStr);
                }
            }
        }
        
        return false;
    }
}
