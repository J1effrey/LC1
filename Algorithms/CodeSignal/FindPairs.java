package com.yyf.practice;

import java.util.Arrays;
/*
You are given two arrays of integers a and b, and two integers lower and upper.
Your task is to find the number of pairs (i, j) such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
*/
public class FindPairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        /*int[] a = {3, -1, 9};
        int[] b = {100, 5, -2};
        int lower = 7;
        int upper = 99;*/
        int[] a = {-321, -196, -983, -863, -55, -84, -926, -47, -771, -603, -464, -971, -438, -649, -792, -737, -344, -260, -429, 0, -716, -16, -680, -778, -277, -767, -103, -573, -951, -741, -22, -332, -447, -369, -240, -989, -464, -758, -292, -549, -653, -569, -665, -240, -621, -918, -8, -910, -362, -595, -515, -817, -725, -872, -924, -6, -15, -296, -845, -955, -861, -234, -768, -879, -393, -37, -976, -784, -907, -662, -755, -955, -501, -766, -58, -860, 0, -265, -137, -29, -597, -889, -530, -742, -176, -147, -101, -425, -792, -143, -949, -674, -597, -928, -562, -547, -565, -574, -438, -873};
        int[] b = {-49, -353, -167, -247, -774, -419, -148, -294, -350, -246};
        int lower =  0;
        int upper = 1000000000;

        System.out.println(countPairs(a, b, lower, upper));
    }

    public static int countPairs(int[] a, int [] b, int lower, int upper) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
        int count = 0;
        Arrays.sort(a);
        for (int i= 0; i < b.length; i++) {
            int curr = b[i] * b[i];
            if (lower - curr > a[a.length - 1] || upper - curr < a[0]) {
                continue;
            }
            int low = bSearch(a, lower - curr);
            int high = bSearch2(a, upper - curr);
            count += high - low + 1;
        }
        return count;
    }

    public static int bSearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int bSearch2(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left< right) {
            int mid = (left + right) / 2 + 1;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /*public static int bSearch2(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[right] <= x) {
            return right;
        }
        return left;
    }*/
}

/*
* * a: [-321, -196, -983, -863, -55, -84, -926, -47, -771, -603, -464, -971, -438, -649, -792, -737, -344, -260, -429, 0, -716, -16, -680, -778, -277, -767, -103, -573, -951, -741, -22, -332, -447, -369, -240, -989, -464, -758, -292, -549, -653, -569, -665, -240, -621, -918, -8, -910, -362, -595, -515, -817, -725, -872, -924, -6, -15, -296, -845, -955, -861, -234, -768, -879, -393, -37, -976, -784, -907, -662, -755, -955, -501, -766, -58, -860, 0, -265, -137, -29, -597, -889, -530, -742, -176, -147, -101, -425, -792, -143, -949, -674, -597, -928, -562, -547, -565, -574, -438, -873]
b: [-49, -353, -167, -247, -774, -419, -148, -294, -350, -246]
lower: 0
upper: 1000000000

1000


Example

For a = [3, -1, 9], b = [100, 5, -2], lower = 7, and upper = 99, the output should be solution(a, b, lower, upper) = 4.

There are only four pairs that satisfy the requirement:

If i = 0 and j = 1, then a[0] = 3, b[1] = 5, and 7 ≤ 3 * 3 + 5 * 5 = 9 + 25 = 36 ≤ 99.
If i = 0 and j = 2, then a[0] = 3, b[2] = -2, and 7 ≤ 3 * 3 + (-2) * (-2) = 9 + 4 = 13 ≤ 99.
If i = 1 and j = 1, then a[1] = -1, b[1] = 5, and 7 ≤ (-1) * (-1) + 5 * 5 = 1 + 25 = 26 ≤ 99.
If i = 2 and j = 2, then a[2] = 9, b[2] = -2, and 7 ≤ 9 * 9 + (-2) * (-2) = 81 + 4 = 85 ≤ 99.
For a = [1, 2, 3, -1, -2, -3], b = [10], lower = 0, and upper = 100, the output should be solution(a, b, lower, upper) = 0.

Since the array b contains only one element 10 and the array a does not contain 0, it is not possible to satisfy 0 ≤ a[i] * a[i] + 10 * 10 ≤ 100.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

    A first array of integers.

    Guaranteed constraints:
    1 ≤ a.length ≤ 105,
    -104 ≤ a[i] ≤ 104.

[input] array.integer b

    A second array of integers.

    Guaranteed constraints:
    1 ≤ b.length ≤ 105,
    -104 ≤ b[i] ≤ 104.

[input] integer lower

    An integer representing a lower bound of a satisfiable square sum.

    Guaranteed constraints:
    0 ≤ lower ≤ 109.

[input] integer upper

    An integer representing an upper bound of a satisfiable square sum.

    Guaranteed constraints:
    lower ≤ upper,
    0 ≤ upper ≤ 10^9.

*
[output] integer
    The number of pairs (i, j) such, that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper. It is guaranteed that the answer fits in 32-bit value type.
* */
