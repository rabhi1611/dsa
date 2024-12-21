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
        if(head == null){
            return head;
        }
        
        int sz = 0;
        ListNode temp = head;
        
        while(temp != null){
            sz++;
            temp = temp.next;
        }
        
        int ridx = sz - n;
        
        temp = head;
        ListNode prev = null;
        
        while(ridx != 0){
            ridx--;
            prev = temp;
            temp = temp.next;
        }
        
        if(prev == null){
            temp = temp.next;
            head.next = null;
            return temp;
        }
        
        prev.next = temp.next;
        temp.next = null;
        
        return head;
    }
}