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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // What if I push all nodes onto the stack and then remove the nth node while popping? Less space efficient BUT same time complexity
        ListNode start = new ListNode();
        start.next = head;
        int c = 0;
        ListNode prev = start;
        ListNode curr = start;
        // Create a gap of n nodes between prev and curr
        while (c != n + 1 && curr != null) { 
            curr = curr.next;
            c++;
        }

        while (curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        // Skip nth node
        prev.next = prev.next.next;

        return start.next;
    }
}