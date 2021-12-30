public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        
        if (sizeA > sizeB) {
            headA = moveKSteps(headA, sizeA - sizeB);
        } else {
            headB = moveKSteps(headB, sizeB - sizeA);
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
    
    private ListNode moveKSteps(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        return node;
    }

    private int getSize(ListNode head) {
        ListNode ptr = head;
        int count = 0;

        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        return count;
    }
}
