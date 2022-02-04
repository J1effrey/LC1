class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0 || k <= 0) {
            return null;
        }
        
        int[][] res = new int[k][2];
        
        partition(points, 0, points.length - 1, k - 1);
        
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        
        return res;
    }
    
    private void partition(int[][] points, int start, int end, int k) {
        if (start == end) {
            return;
        }
        
        int left = start;
        int right = end;
        int[] pivot = points[(left + right) / 2];
        int pivotDis = getDis(pivot);
        
        while (left <= right) {
            while (left <= right && getDis(points[left]) < pivotDis) {
                left++;
            }
            
            while (left <= right && getDis(points[right]) > pivotDis) {
                right--;
            }
            
            if (left <= right) {
                swap(points, left++, right--);
            }
        }
        
        if (k <= right) {
            partition(points, start, right, k);
        } else if (k >= left) {
            partition(points, left, end, k);
        }       
    }
    
    private void swap(int[][] array, int a, int b) {
        int[] temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    private int getDis(int[] point) {
        return point[1] * point[1] + point[0] * point[0];
    }
}
