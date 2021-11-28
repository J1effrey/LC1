class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        if (arr == null || arr.length == 0 || k <= 0) {
            return res;
        }
        
        int closetIndex = getIndexOfOneClosestElement(arr, x);
        res.add(arr[closetIndex]);
        int left = closetIndex - 1;
        int right = closetIndex + 1;
        
        while (res.size() < k && left >= 0 && right < arr.length) {
            int disOfLeft = Math.abs(arr[left] - x);
            int disOfRight = Math.abs(arr[right] - x);
            
            if (disOfLeft <= disOfRight) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        
        while (res.size() < k) {
            if (left < 0) {
                while (res.size() < k) {
                    res.add(arr[right++]);
                }
                break;
            } 
            
            while (res.size() < k) {
                res.add(arr[left--]);
            }
        }
        
        Collections.sort(res);
        return res;
    }
    
    private int getIndexOfOneClosestElement(int[] arr, int x) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        int disOfStart = Math.abs(arr[start] - x);
        int disOfEnd = Math.abs(arr[end] - x);
        
        return disOfStart <= disOfEnd ? start : end;
    }
}
