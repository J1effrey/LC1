package com.yyf.codesignal;

import java.util.Arrays;

/**
 * @author yifei yang
 * You are given two integer arrays a and b of the same length.
 * Let's define the difference between a and b as the sum of absolute differences of corresponding elements:
 * difference = |a[0] - b[0]| + |a[1] - b[1]| + ... + |a[a.length - 1] - b[b.length - 1]|
 * You can replace one element of a with any other element of a.
 * Your task is to return the minimum possible difference between a and b that can be achieved by performing at most one such replacement on a.
 * You can also choose to leave the array intact.
 */
public class ReduceDifferenceByReplacing {
    public static void main(String[] args) {
        int[] a = {9064, -5167, -2855, 2333, 7177, 1584, 7621, 9954, 6687, 5, -6459, -8069, 8265, 4601};
        int[] b = {8366, -5167, -2855, 2333, 7177, 1584, 7621, -2741, 6687, 5, 4062, 514, 8265, 4601};

//        int[] a = {1, 3, 5};
//        int[] b = {5, 3, 1};
        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int res = 0;
        int[] sorted = a.clone();
        Arrays.sort(sorted);

        int n = a.length;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(a[i] - b[i]);
            if (a[i] != b[i]) {
                System.out.println(binarySearch(i, b[i], sorted));
                maxDiff = Math.max(maxDiff, binarySearch(i, b[i], sorted));
            }
        }
        return res - maxDiff;
    }

    public static int binarySearch(int start, int target, int[] a) {
        int index = searchInsertPosition(target, a);
        if (index == 0 || index == a.length - 1) {
            return hasShortedDistance(start, index, start, a) ? Math.abs(a[start] - target) - Math.abs(a[index] - target) : 0;
        } else {
            int candidate1 = hasShortedDistance(start, index, target, a) ? Math.abs(a[start] - target) - Math.abs(a[index] - target) : 0;
            int candidate2 = hasShortedDistance(start, index + 1, target, a) ? Math.abs(a[start] - target) - Math.abs(a[index] - target) : 0;
            return Math.max(candidate1, candidate2);
        }
    }

    private static boolean hasShortedDistance(int start, int index, int target, int[] a) {
        return Math.abs(a[index] - target) < Math.abs(a[start] - target);
    }

    public static int searchInsertPosition(int target, int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
/**
 * Example
 * For a = [1, 3, 5] and b = [5, 3, 1], the output should be solution(a, b) = 4.
 * 	• If we leave the array a intact, the difference is |1 - 5| + |3 - 3| + |5 - 1| = 8;
 * 	• If we replace a[0] with a[1], we get a = [3, 3, 5] and the difference is |3 - 5| + |3 - 3| + |5 - 1| = 6;
 * 	• If we replace a[0] with a[2], we get a = [5, 3, 5] and the difference is |5 - 5| + |3 - 3| + |5 - 1| = 4;
 * 	• If we replace a[1] with a[0], we get a = [1, 1, 5] and the difference is |1 - 5| + |1 - 3| + |5 - 1| = 10;
 * 	• If we replace a[1] with a[2], we get a = [1, 5, 5] and the difference is |1 - 5| + |5 - 3| + |5 - 1| = 10;
 * 	• If we replace a[2] with a[0], we get a = [1, 3, 1] and the difference is |1 - 5| + |3 - 3| + |1 - 1| = 4;
 * 	• If we replace a[2] with a[1], we get a = [1, 3, 3] and the difference is |1 - 5| + |3 - 3| + |3 - 1| = 6;
 * So the final answer is 4, since it's the minimum possible difference.
 *
 * Input/Output
 *
 * 	• [execution time limit] 3 seconds (java)
 *
 * 	• [input] array.integer a
 * The first array of integers.
 * Guaranteed constraints:
 * 2 ≤ a.length ≤ 105,
 * -104 ≤ a[i] ≤ 104.
 *
 * 	• [input] array.integer b
 * The second array of integers.
 * Guaranteed constraints:
 * b.length = a.length,
 * -104 ≤ b[i] ≤ 104.
 *
 * 	• [output] integer
 * The minimum possible difference between a and b after replacing at most one element of a to any element from the same array, or leaving everything intact.
 */