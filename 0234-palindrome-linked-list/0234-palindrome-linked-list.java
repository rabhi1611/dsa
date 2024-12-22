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
        
        ListNode temp = head;
        Stack<ListNode> st = new Stack<>();
        
        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }
        
        while(!st.isEmpty()){
            if(st.peek().val != head.val){
                return false;
            }
            st.pop();
            head = head.next;
        }
        
        return true;
    }
}