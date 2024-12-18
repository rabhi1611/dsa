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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode sAns = reverseList(head.next);
        
        if(sAns == null){
            return head;
        }
        
        ListNode temp = sAns;
        
        while(temp.next != null){
            temp = temp.next;
        }
        
        temp.next = head; 
        head.next = null;
        
        return sAns;
    }
}