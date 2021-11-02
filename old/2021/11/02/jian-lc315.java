class Solution {
    class TreeNode {
        int count;
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
            this.count = 1;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return res;    
        }
        
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            int smallerCount = insertNode(root, nums[i]);
            res.add(0, smallerCount);
        }
        
        return res;
    }
    
    private int insertNode(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        int smallerCount = 0;
        
        while (root != null) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = newNode;
                    root = null;
                } else {
                    root = root.left;
                }
            } else {
                smallerCount += root.count;
                if (root.right == null) {
                    root.right = newNode;
                    root = null;
                } else {
                    root = root.right;
                }
            }
        }
        return smallerCount;
    }
}
