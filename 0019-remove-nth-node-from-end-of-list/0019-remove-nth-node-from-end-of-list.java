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
    public ListNode removeNthFromEnd(ListNode head, int pnt) {
        ListNode temp = head;
        int n = 0;

        while(temp != null){
            n += 1;
            temp = temp.next;
        }

        n -= pnt;
        n -= 1;

        if(n < 0){
            return head.next;
        }

        temp = head;

        while(n > 0){
            temp = temp.next;
            n -= 1;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
        } 

        return head;
    }
}