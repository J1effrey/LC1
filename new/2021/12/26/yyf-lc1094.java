class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0 || trips[0].length == 0 || capacity <= 0) {
            return false;
        }
        int[] bucket = new int[1001];
        for (int[] trip : trips) {
            bucket[trip[1]] += trip[0];
            bucket[trip[2]] -= trip[0];
        }
        
        int currCapacity = 0;
        for (int i : bucket) {
            currCapacity += i;
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}

/*
2 1 5
3 3 7

4 

1 3  5  7
2 3 -2 -3

O(NlogN)
O(N)


O(max{N, 1001});
O(1001) => O(1)
*/
