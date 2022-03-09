// O(logn), n is length of mountain array
// O(1)

// simplied, works only with valid mountain
class Solution {
    private int len = 0;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.len = mountainArr.length();
        
        int start = 0;
        int end = len - 1;
        int mountainTop = 0;
        
        boolean foundTop = false;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            int cur = mountainArr.get(mid);
            int left = mountainArr.get(mid - 1);
            int right = mountainArr.get(mid + 1);

            if (cur > left && cur > right) {
                foundTop = true;
                mountainTop = mid;
                break;
            } else if (cur > left && cur < right){
                start = mid;
            } else {
                end = mid;
            }
        }

        
        int leftRes = searchLeft(target, mountainArr, 0, mountainTop);
        
        if (leftRes != -1) {
            return leftRes;
        }
        
        return searchRight(target, mountainArr, mountainTop, len - 1);
    }
    
    
    private int searchLeft(int target, MountainArray mountainArr, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (mountainArr.get(start) == target) {
            return start;
        }
        
        if (mountainArr.get(end) == target) {
            return end;
        }
        
        return -1;
    }
    
    private int searchRight(int target, MountainArray mountainArr, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement < target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (mountainArr.get(start) == target) {
            return start;
        }
        
        if (mountainArr.get(end) == target) {
            return end;
        }
        
        return -1;
    }
}

======
// more protective 
class Solution {
    private int len = 0;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.len = mountainArr.length();
        
        int start = 0;
        int end = len - 1;
        int mountainTop = 0;
        
        boolean foundTop = false;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isValid(mid - 1) && isValid(mid + 1)) {
                int cur = mountainArr.get(mid);
                int left = mountainArr.get(mid - 1);
                int right = mountainArr.get(mid + 1);
                
                if (cur > left && cur > right) {
                    foundTop = true;
                    mountainTop = mid;
                    break;
                } else if (cur > left && cur < right){
                    start = mid;
                } else {
                    end = mid;
                }
                
            } else if (!isValid(mid - 1)) {
                start = mid;    
            } else {
                end = mid;
            }
        }
        
        if (!foundTop) {
            foundTop = true;
            mountainTop = mountainArr.get(start) > mountainArr.get(end) ? start : end;
        }
        
        int leftRes = searchLeft(target, mountainArr, 0, mountainTop);
        int RightRes = searchRight(target, mountainArr, mountainTop, len - 1);
        
        if (leftRes != -1) {
            return leftRes;
        }
        
        return RightRes;
    }
    
    private boolean isValid(int x) {
        return x >= 0 && x < len;
    } 
    
    private int searchLeft(int target, MountainArray mountainArr, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (mountainArr.get(start) == target) {
            return start;
        }
        
        if (mountainArr.get(end) == target) {
            return end;
        }
        
        return -1;
    }
    
    private int searchRight(int target, MountainArray mountainArr, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement < target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (mountainArr.get(start) == target) {
            return start;
        }
        
        if (mountainArr.get(end) == target) {
            return end;
        }
        
        return -1;
    }
}
