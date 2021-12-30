// doubleLinkedList
class LFUCache {
    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
            prev = null;
            next = null;
        }
    }
    
    class DoubledLinkedList {
        Node head;
        Node tail;
        int size;
        
        DoubledLinkedList() {
            size = 0;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        
        public void add(Node node) { // add to head
            if (node == null) {
                return;
            }
            // head node next tail
            Node next = head.next;
            node.next = next;
            node.prev = next.prev;
            head.next = node;
            next.prev = node;
            size++;
        }
        
        public void remove(Node node) {
            if (node == null) {
                return;
            }
            // head ... prev node next ... tail
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }
        
        public Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }
    
    private int capacity;
    private int min = 1;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, DoubledLinkedList> freqMap; // freq map

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            addFreq(nodeMap.get(key));
            return nodeMap.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!nodeMap.containsKey(key)) {
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            if (nodeMap.size() > capacity) {
                Node removedNode = freqMap.get(min).removeLast();
                nodeMap.remove(removedNode.key);
            }
            DoubledLinkedList list = freqMap.getOrDefault(newNode.freq, new DoubledLinkedList());
            list.add(newNode);
            freqMap.put(newNode.freq, list);
            min = 1;
        } else {
            Node node = nodeMap.get(key);
            node.val = value;
            addFreq(nodeMap.get(key));
        }
    }
    
    public void addFreq(Node node) { // node.freq must exist, no check
        DoubledLinkedList oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if (min == node.freq && oldList.size == 0) {
            min++;
        }
        node.freq++;
        DoubledLinkedList newList = freqMap.getOrDefault(node.freq, new DoubledLinkedList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}


/*=============================================================================================================================================================================*/
// linkedHashSet
class LFUCache {
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> list; 
    int minCount = 1;
    int capacity;

    public LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        list = new HashMap<>();
        this.capacity = capacity;
        list.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        list.get(count).remove(key);
        if (!list.containsKey(count + 1)) {
            list.put(count + 1, new LinkedHashSet<>());
        }
        list.get(count + 1).add(key);
        if (count == minCount && list.get(count).size() == 0) {
            minCount  = count + 1;
        }
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= capacity) {
            int deleteKey = list.get(minCount).iterator().next();
            vals.remove(deleteKey);
            counts.remove(deleteKey);
            list.get(minCount).remove(deleteKey);
        }
        vals.put(key, value);
        counts.put(key, 1);
        minCount = 1;
        list.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
vals
counts
list: count -> LinkedHashSet<> keys
minCount = 1;
*/
