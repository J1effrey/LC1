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
