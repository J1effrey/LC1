/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null) {
            return -1;
        }
        
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = 0;
        int col = dimensions.get(1) - 1;
        
        int res = -1;
        
        while (row < dimensions.get(0) && col >= 0) {
            if (binaryMatrix.get(row, col) == 1) {
                res = col;
                col--;
            } else {
                row++;
            }
        }
        return res;
    }
}
