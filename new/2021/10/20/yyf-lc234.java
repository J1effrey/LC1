// Best Solution
// dummy used to reverse the 1st half
// do the reverse of first half and find middle point togeter!!!
// one pass, T: O(n) S: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        ListNode fast = head;
        
        ListNode dummy = new ListNode();
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            
            ListNode next = head.next;
            ListNode dummyNext = dummy.next;
            dummy.next = head;
            head.next = dummyNext;
            head = next;
        }
        
        if (fast != null) {
            head = head.next;
        }
        
        ListNode first = dummy.next;
        ListNode second = head;
        
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
}

-------------
// 2nd best
    
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode newHead = reverse(slow);
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

/*

// worst solution

class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
*/
