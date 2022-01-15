public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

=======
    
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        ListNode evenStart = evenTail;
        
        ListNode odd = head.next.next;
        oddTail.next = null;
        evenTail.next = null;

        while (odd != null) {
            ListNode even = odd.next;
            
            ListNode nextOddTail = oddTail.next;
            oddTail.next = odd;
            odd.next = nextOddTail;
            oddTail = oddTail.next;
            
            if (even == null) {
                evenTail = null;
                break;
            }
            
            ListNode nextEven = even.next;
            ListNode nextEvenTail = evenTail.next;
            evenTail.next = even;
            even.next = nextEvenTail;
            evenTail = evenTail.next;
            
            odd = nextEven;
        }
        
        oddTail.next = evenStart;
        
        return head;
    }
}
