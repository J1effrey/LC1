/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
