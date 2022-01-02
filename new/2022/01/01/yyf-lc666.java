// hashmap
class Solution {
    int ans = 0;
    Map<Integer, Integer> values;
    public int pathSum(int[] nums) {
        values = new HashMap();
        for (int num: nums)
            values.put(num / 10, num % 10);

        dfs(nums[0] / 10, 0);
        return ans;
    }

    public void dfs(int node, int sum) {
        if (!values.containsKey(node)) return;
        sum += values.get(node);

        int depth = node / 10, pos = node % 10;
        int left = (depth + 1) * 10 + 2 * pos - 1;
        int right = left + 1;

        if (!values.containsKey(left) && !values.containsKey(right)) {
            ans += sum;
        } else {
            dfs(left, sum);
            dfs(right, sum);
        }
    }
}

--------------------------------------------------------------------------------
// O(N)
// O(N)
// node
class Solution {
    int ans = 0;
    public int pathSum(int[] nums) {
        Node root = new Node(nums[0] % 10);
        for (int num : nums) {
            if (num == nums[0]) {
                continue;
            }
            int depth = num / 100;
            int position = num / 10 % 10;
            int val = num % 10;
            position--;
            Node curr = root;
            for (int i = depth - 2; i >= 0; i--) {
                if (position < 1 << i) {
                    if (curr.left == null) {
                        curr.left = new Node(val);
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node(val);
                    }
                    curr = curr.right;
                }
                position %= 1 << i;
            }
        }
        dfs(root, 0);
        return ans;
    }
    
    public void dfs(Node node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (node.left == null && node.right == null) {
            ans += sum;
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }
}

class Node {
    Node left;
    Node right;
    int val;
    public Node(int v) {val = v;}
}

