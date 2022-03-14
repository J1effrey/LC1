class LRUCache {
    class DNode{
        int key;
        int value;
        DNode prev;
        DNode next;
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, DNode> map = new HashMap<Integer, DNode>();
    int capacity;
    DNode head;
    DNode tail;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        head = new DNode(-1, -1);
        tail = new DNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        DNode n = map.get(key);
        removeNode(n);
        moveNodeToHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            DNode node = map.get(key);
            node.value = value;
            return;
        } 
        
        DNode newNode = new DNode(key, value);
        map.put(key, newNode);
        moveNodeToHead(newNode);
        
        if (map.size() > capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
    }
    
    private void moveNodeToHead(DNode n) {
        DNode nextOfHead = head.next;
        head.next = n;
        nextOfHead.prev = n;
        n.prev = head;
        n.next = nextOfHead;
    }
    
    private void removeNode(DNode n) {
        DNode nextOfNode = n.next;
        DNode prevOfNode = n.prev;
        prevOfNode.next = nextOfNode;
        nextOfNode.prev = prevOfNode;
    }
    
}




--------------------------------------------------------------------------
public class LRUCache {
    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if( !hs.containsKey(key)) {			//key找不到
            return -1;
        }

        // remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // move current to tail
        move_to_tail(current);			//每次get，使用次数+1，最近使用，放于尾部

        return hs.get(key).value;
    }

    public void put(int key, int value) {			//数据放入缓存
        // get 这个方法会把key挪到最末端，因此，不需要再调用 move_to_tail
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {		//超出缓存上限
            hs.remove(head.next.key);		//删除头部数据
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);		//新建节点
        hs.put(key, insert);
        move_to_tail(insert);					//放于尾部
    }

    private void move_to_tail(Node current) {    //移动数据至尾部
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        moveToTail(curr);
        
        return curr.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
    }
    
    private void moveToTail(Node node) {
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
        node.next = tail;
    }
}
*/
