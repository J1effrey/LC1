/*
head and tail can ensure both getMaxKey() and getMaxKey() be done in O(1).
keyCountMap maintains the count of keys, countBucketMap provides O(1) access to a specific Bucket with given count. Deleting and adding a Bucket in the Bucket list cost O(1), so both inc() and dec() take strict O(1) time.
*/


public class AllOne {

    private class Node {
        Integer val;
        Set<String> set;
        Node pre;
        Node next;

        Node(Integer val) {
            this.val = val;
            this.set = new HashSet<>();
        }

        void prepend(Node node) {
            this.pre.next = node;
            node.pre = this.pre;
            node.next = this;
            this.pre = node;
        }

        void append(Node node) {
            this.next.pre = node;
            node.next = this.next;
            node.pre = this;
            this.next = node;
        }

        void delete() {
            pre.next = next;
            next.pre = pre;
            pre = null;
            next = null;
        }
    }


    private HashMap<String, Integer> keyMap;
    private HashMap<Integer, Node> valMap;
    private Node head;
    private Node tail;

    public AllOne() {
        keyMap = new HashMap<>();
        valMap = new HashMap<>();
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyMap.put(key, 1);
            if (valMap.containsKey(1)) {
                valMap.get(1).set.add(key);
            } else {
                Node node = new Node(1);
                node.set.add(key);
                valMap.put(1, node);
                tail.prepend(node);
            }
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Integer val = keyMap.get(key);
        if (val == null) {
            return;
        }
        Node node = valMap.get(val);
        if (node.val == 1) {
            keyMap.remove(key);
            removeKeyFromNode(node, key);
        } else {
            changeKey(key, -1);
        }
    }


    /////////HELPER////////////

    private void changeKey(String key, int offset) {
        Integer val = keyMap.get(key);
        keyMap.put(key, val + offset);
        Node valNode = valMap.get(val);
        Node targetValNode = valMap.get(val + offset);
        if (targetValNode == null) {
            targetValNode = new Node(val + offset);
            valMap.put(val + offset, targetValNode);
            if (offset == 1) {
                valNode.prepend(targetValNode);
            } else {
                valNode.append(targetValNode);
            }
        }
        targetValNode.set.add(key);
        removeKeyFromNode(valNode, key);
    }

    private void removeKeyFromNode(Node node, String key) {
        node.set.remove(key);
        if (node.set.isEmpty()) {
            valMap.remove(node.val);
            node.delete();
        }
    }

    /////////HELPER////////////


    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return head.next == tail ? "" : head.next.set.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return tail.pre == head ? "" : tail.pre.set.iterator().next();
    }
}
