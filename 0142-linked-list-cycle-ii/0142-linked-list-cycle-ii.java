/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head, fast = head;

        do {
            if(slow == null){
                return null;
            }

            if(fast == null){
                return null;
            }

            if(fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);


        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}