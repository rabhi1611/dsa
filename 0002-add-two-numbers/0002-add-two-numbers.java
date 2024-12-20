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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;
        
        while(l1 != null && l2 != null){
            int sum = (l1.val + l2.val + rem) % 10;
            rem = (l1.val + l2.val + rem) / 10;
            
            temp.next = new ListNode(sum);
            temp = temp.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int sum = (l1.val + rem) % 10;
            rem = (l1.val + rem) / 10;
            
            temp.next = new ListNode(sum);
            temp = temp.next;

            l1 = l1.next;
        }
        
        
        while(l2 != null){
            int sum = (l2.val + rem) % 10;
            rem = (l2.val + rem) / 10;
            
            temp.next = new ListNode(sum);
            temp = temp.next;

            l2 = l2.next;
        }
        
        if(rem > 0){
            temp.next = new ListNode(rem);
            temp = temp.next;            
        }
        
        return ans.next;
    }
}