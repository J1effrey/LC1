public class SegmentTree-without-arrays {
    static class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        public SegmentTreeNode(int start, int end, int sum, SegmentTreeNode left, SegmentTreeNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] vals = {2, 1, 5, 3, 4};
        SegmentTreeNode root = buildTree(0, 4, vals);
        updateTree(root, 2, 10);
        System.out.println(querySum1(root, 1, 3));
        System.out.println(querySum2(root, 1, 3));
    }

    public static SegmentTreeNode buildTree(int start, int end, int[] vals) {
        if (start == end) {
            return new SegmentTreeNode(start, end, vals[start]);
        }
        int mid = (start + end) / 2;
        SegmentTreeNode left = buildTree(start, mid, vals);
        SegmentTreeNode right = buildTree(mid + 1, end, vals);
        return new SegmentTreeNode(start, end, left.sum + right.sum, left, right);
    }

    public static void updateTree(SegmentTreeNode root, int index, int val) {
        if (root.start == root.end && root.start == index ) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid) {
            updateTree(root.left, index, val);
        } else {
            updateTree(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    // hua hua
    public static int querySum1(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        if (j <= mid) {
            return querySum1(root.left, i, j);
        } else if (i > mid) {
            return querySum1(root.right, i, j);
        } else {
            return querySum1(root.left, i, mid) + querySum1(root.right, mid + 1, j);
        }
    }

    // Tushar Roy
    public static int querySum2(SegmentTreeNode root, int i, int j) {
        if (root.start >= i && root.end <= j) {
            return root.sum;
        }

        if (j < root.start || i > root.end) {
            return 0;
        }
        int leftSum = querySum2(root.left, i, j);
        int rightSum = querySum2(root.right, i, j);

        return leftSum + rightSum;
    }
}