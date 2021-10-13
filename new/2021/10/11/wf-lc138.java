/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*
    1->2->3->4
    1->1'->2->2'->3->3'->4->4'  
    */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitNodes(head);
    }
    
    private void copyNext(Node head) {
        while (head != null) {
            Node newNode = new Node(head.val);
            Node next = head.next;
            head.next = newNode;
            newNode.next = next;
            head = next;
        }
    }
    
    private void copyRandom(Node head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private Node splitNodes(Node head) {
        Node newHead = head.next;
        while (head != null) {
            Node temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}