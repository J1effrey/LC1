class Solution {
    Random random;
    int[] sum;
    int maxSum;
    public Solution(int[] w) {
        random = new Random();
        sum = new int[w.length];
        sum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
        maxSum = sum[w.length - 1];
    }
    
    public int pickIndex() {
        int target = random.nextInt(maxSum) + 1;
        int start = 0;
        int end = sum.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sum[mid] == target) {
                return mid;
            }
            if (sum[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (sum[start] >= target) {
            return start;
        }
        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
