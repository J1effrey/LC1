class Solution {
    private boolean find(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val) 
            return true;
        if (n.left != null && find(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && find(n.right, val, sb))
            sb.append("R");
        return sb.length() > 0;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        int i = 0, max_i = Math.min(d.length(), s.length());
        while (i < max_i && s.charAt(s.length() - i - 1) == d.charAt(d.length() - i - 1))
            ++i;
        return "U".repeat(s.length() - i) + d.reverse().toString().substring(i);
    }
}

===

class Solution {
    StringBuilder path = new StringBuilder();
    String startPath;
    String destPath;
    int startValue;
    int destValue;
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;
        // 寻找走到 startValue 和 destValue 的方向路径
        traverse(root);
        
        // 去除两个方向路径的公共前缀
        int p = 0;
        int m = startPath.length();
        int n = destPath.length();
        while (p < m && p < n && startPath.charAt(p) == destPath.charAt(p)) {
            p++;
        }
        startPath = startPath.substring(p);
        destPath = destPath.substring(p);
        // 将走向 startValue 的方向路径全部变成 U
        startPath = "U".repeat(startPath.length());
        // 组合 startPath 和 destPath 就得到了答案
        return startPath + destPath;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.val == startValue) {
            startPath = path.toString();
        } else if (root.val == destValue) {
            destPath = path.toString();
        }

        path.append('L');
        traverse(root.left);
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
