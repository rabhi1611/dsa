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
        if(head == null || head.next == null){
            return true;
        }
        
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        
        ListNode temp = head;
        
        while(temp != null){
            one.append(temp.val);
            if(two.length() == 0)
                two.append(temp.val);
            else
                two.insert(0, temp.val);
            
            temp = temp.next;
        }
     
        return one.toString().equals(two.toString());
    }
}