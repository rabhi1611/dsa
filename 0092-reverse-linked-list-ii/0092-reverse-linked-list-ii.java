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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int n = 1;

        ListNode prev = null, i = head, j = head, next = null;

        while(n != left){
            prev = i;
            i = i.next;
            n = n + 1;
        }

        j = i;
        while(n != right){
            j = j.next;
            n = n + 1;
        }

        next = j.next;
        j.next = null;

        // we have i to reverse
        
        ListNode rev = reverse(i);

        // return top

        if(prev != null){
            prev.next = rev;
            i.next = next;
            return head;
        } else {
            i.next = next;
            return rev;
        }
    }


    private ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode temp = node.next;
        ListNode subAns = reverse(node.next);

        temp.next = node;
        node.next = null;

        return subAns;
    }
}