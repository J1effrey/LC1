class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int d : bloomDay) {
            left = Math.min(left, d);
            right = Math.max(right, d);
        }
        while (left < right) {
            int mid = left + (right -left) / 2;
            int bouq = 0;
            int flowers = 0;
            for (int d : bloomDay) {
                if (d > mid) {
                    flowers = 0;
                    continue;
                }
                flowers++;
                if (flowers == k) {
                    bouq++;
                    flowers = 0;
                }
            }
            if (bouq >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    
}
