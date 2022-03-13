// T:O(row + col)
// S:O(1)
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);
        
        int startRow = 0;
        int startCol = col - 1;
        int res = -1;
        
        while (startRow < row && startCol >= 0) {
            if (binaryMatrix.get(startRow, startCol) == 1) {
                res = startCol;
                startCol--;
                continue;
            }
            startRow++;
        }
        
        return res;
    }
}
