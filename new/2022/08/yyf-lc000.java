import java.util.Arrays;

/**
 * @author yifei yang
 */
public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        System.out.println(invCount(arr));
    }

    public static int invCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }
    
    // Divide: Merge sort function
    public static int mergeSortAndCount(int[] arr, int l, int r) {
        // Keeps track of the inversion count at a
        // particular node of recursion tree
        int count = 0;
        if (l >= r) {
            return count;
        }
        int m = (l + r) / 2;
        
        // Total inversion count = left subarray count + right subarray count + merge count
        // Left subarray count
        count += mergeSortAndCount(arr, l, m);
        
        // Right subarray count
        count += mergeSortAndCount(arr, m + 1, r);
        
        // Merge count
        count += mergeAndCount(arr, l, m, r);
        return count;
    }
    
    // Conquer & merge
    public static int mergeAndCount(int[] arr, int l, int m, int r) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        
        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0;
        int j = 0;
        int k = l;
        int swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[i]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        return swaps;
    }

}
