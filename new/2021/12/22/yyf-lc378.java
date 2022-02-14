// T:O(KlogR+R) R is heap size
// S:O(R)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(j,0,matrix[j][0])); // O(row)
        } 
        for (int i = 0; i < k - 1; i++) { // O(K)
            Tuple t = pq.poll(); 
            if (t.y == matrix[0].length - 1) {
                continue;
            }
            pq.offer(new Tuple(t.x, t.y+1,matrix[t.x][t.y+1]));  // O(logR)
        }
        return pq.poll().val;
    }
    
    class Tuple implements Comparable<Tuple>{
        int x;
        int y;
        int val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
}
