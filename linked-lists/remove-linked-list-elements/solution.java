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
    public ListNode removeElements(ListNode head, int val) {
        // Base case: if the list is empty return null
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            // Remove the head
            return removeElements(head.next, val);
        } else {
            // Keep the head, check the rest of the list
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}