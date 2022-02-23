//Time: O(n)
//Space: O(1)
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        int res = 0;
        
        if (root.val >= low && root.val <= high) {
            res += root.val;
            res += rangeSumBST(root.left, low, high);
            res += rangeSumBST(root.right, low, high);
        } else if (root.val < low) {
            res += rangeSumBST(root.right, low, high);
        } else {
            res += rangeSumBST(root.left, low, high);
        }
        
        return res;
    }
}
