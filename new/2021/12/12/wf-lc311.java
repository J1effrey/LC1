//击败100%
// T:O(rowA * colA * colB)
// S:O(1)
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return B;
        }
        if (B == null || B.length == 0 || B[0] == null || B[0].length == 0) {
            return A;
        }
        int rowOfA = A.length;
        int colOfA = A[0].length;
        int colOfB = B[0].length;
        int[][] res = new int[rowOfA][colOfB];

        for(int i = 0; i < rowOfA; i++) {
            for(int j = 0; j < colOfA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colOfB; k++) {
                        if (B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return res;   
    }
}

--------------------
//击败10%
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        if (mat1 == null || mat1.length == 0 || mat1[0] == null || mat1[0].length == 0) {
            return mat2;
        }
        if (mat2 == null || mat2.length == 0 || mat2[0] == null || mat2[0].length == 0) {
            return mat1;
        }
        
        int rowA = mat1.length;
        int colA = mat1[0].length;
        int rowB = mat2.length;
        int colB = mat2[0].length;
        
        int[][] res = new int[rowA][colB];
        
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                int sum = 0;
                for (int k = 0; k < colA; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }
                res[i][j] = sum;
            }
        }
        return res;
    }
}
