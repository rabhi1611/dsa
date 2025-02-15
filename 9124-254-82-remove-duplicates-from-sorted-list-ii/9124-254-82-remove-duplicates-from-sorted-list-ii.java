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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode t1 = head;
        ListNode t2 = head.next;

        while(t2 != null){
            if(t2.val == t1.val){
                t2 = t2.next;
                continue;
            }
            if(t1.next != t2){
                // t1 is dupilcate
                if(prev != null){              
                    prev.next = t2;
                    t1 = t2;
                    t2 = t2.next;
                }else {
                    head = t2;
                    t1 = t2;
                    t2 = t2.next;
                }
            } else {
                prev = t1;
                t1 = t2;
                t2 = t2.next;
            }
        }

        if(t1.next != t2){
            if(prev != null){              
                prev.next = t2;
            }else {
                head = t2;
            }
        }

        return head;
    }
}