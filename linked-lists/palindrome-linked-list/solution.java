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
        // How about using a stack?
        Stack<ListNode> nums = new Stack<>();
        // Push all nodes onto stack
        ListNode curr = head;
        while (curr != null) { 
            nums.push(curr);
            curr = curr.next;
        }
        // Reset curr = head
        curr = head;
        // Compare backwards
        ListNode temp = new ListNode();
        while (!nums.isEmpty()) { 
            temp = nums.pop();
            if (temp.val != curr.val) return false;
            curr = curr.next;
        }

        return true;
    }
}