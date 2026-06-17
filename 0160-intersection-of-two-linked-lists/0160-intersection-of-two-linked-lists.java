/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        // run one time to find the diffence

        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        if(t1 == null && t2 == null){
            // no differnce
            // didn't intersected as well
            return null;
        }
        else if(t1 == null){
            t1 = headB;
            while(t2 != null){
                t1 = t1.next;
                t2 = t2.next;
            }
            t2 = headA;
        } else {
            t2 = headA;
            while(t1 != null){
                t1 = t1.next;
                t2 = t2.next;
            }
            t1 = headB;
        }

        // run 1 more time
        while(t1 != null && t2 != null){
            if(t1 == t2){
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        return null;
    }
}