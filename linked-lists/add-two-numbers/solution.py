# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # directly compute the number using correct order
        sum_l1 = 0
        multiplier = 1
        while l1 is not None:
            sum_l1 += l1.val * multiplier
            l1 = l1.next
            multiplier *= 10

        sum_l2 = 0
        multiplier = 1
        while l2 is not None:
            sum_l2 += l2.val * multiplier
            l2 = l2.next
            multiplier *= 10

        val = sum_l1 + sum_l2

        # Handle [0] + [0]
        if val == 0:
            return ListNode(0)

        # Build the resulting linked list in reverse order 
        dummy = ListNode(0)
        curr = dummy
        while val > 0:
            digit = val % 10
            curr.next = ListNode(digit)
            curr = curr.next
            val //= 10

        return dummy.next
