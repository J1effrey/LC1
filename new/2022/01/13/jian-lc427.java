/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
    
    private Node construct(int[][] grid, int x1, int x2, int y1, int y2) {
        if(x1 == x2) {
            boolean val = grid[x1][y1] == 1 ? true : false;
            return new Node(val, true, null, null, null, null);
        }
        int rowMid = (x1 + x2) / 2;
        int colMid = (y1 + y2) / 2;
        Node topleft = construct(grid, x1, rowMid, y1, colMid);                       
        Node topright = construct(grid, x1, rowMid, colMid + 1, y2);                       
        Node bottomleft = construct(grid, rowMid + 1, x2, y1, colMid);                       
        Node bottomright = construct(grid, rowMid + 1, x2, colMid + 1, y2);             
        if(topleft.isLeaf && topright.isLeaf && bottomleft.isLeaf && bottomright.isLeaf && topright.val == topleft.val && topright.val == bottomleft.val && topright.val == bottomright.val) {
            return new Node(topleft.val, true, null, null, null, null);
        } else {
            return new Node(false, false, topleft,topright,bottomleft,bottomright);
        }     
    }
}
