// "static void main" must be defined in a public class.
import java.util.*;
public class clearBits {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][] tree = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1},
        };
        clearBit(tree, 2, 3);
        for (int i = 0; i < tree.length; i++) {
            System.out.println(Arrays.toString(tree[i]));
        }

    }

    public static void clearBit(int[][] arr, int start, int len) {
        int height = arr.length - 1;
        int n = start + len;
        for (int i = start; i <= n; i++) {
            if (start % 2 == 0) {
                clear(arr, i, height, false);
            } else {
                clear(arr, i, height, true);
            }
        }
    }

    public static void clear(int[][] arr, int i, int height, boolean isLeft) {
        if (height == 0) {
            arr[0][0] = 0;
            return;
        }
        // i 2 j 3
        int j = isLeft ? i - 1 : i + 1;
        // 1 & 0
        if ((arr[height][i] & arr[height][j]) != 1 ) {
            arr[height][i] = 0;
        } else {
            arr[height][i] = 0;
            i = i / 2; // 2
            height--;
            if (i % 2== 0) {
                clear(arr, i, height, false);
            } else {
                clear(arr, i, height, true);
            }
        }
    }


}

/*
     0
   0     1
 0   0  1   1
0 0 0 0 1 1  1  1
2,3
*/
