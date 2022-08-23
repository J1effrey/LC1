class Solution {
    public int maxDistance(int[] position, int m) {
        if (position.length < m) {
            return 0;
        }
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        return binary(position, m, left, right);
    }
    
    public int binary(int[] position, int m, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(position, m , mid)) {
               left = mid + 1 ;
            }  else {
                right = mid - 1;
            }
        }
        return right;
    }
    
    public boolean isValid(int[] position, int m, int distance) {
        int prev = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            int curr = position[i];
            if (curr - prev >= distance) {
                prev = curr;
                count++;
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
