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

    private ListNode ansHead;

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ansHead = head;
        head = head.next;
        ansHead.next = null;

        while(head != null){
            head = putOnCorrectPos(head);
        }

        return ansHead;
    }


    private ListNode putOnCorrectPos(ListNode head){
        ListNode betNode = head;
        head = head.next;
        betNode.next = null;

        ListNode curr = ansHead;
        ListNode prev = null;

        while(curr != null){
            if(curr.val > betNode.val){
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        if(prev == null){
            betNode.next = curr;
            ansHead = betNode;
        } else{
            betNode.next = prev.next;
            prev.next = betNode;
        }

        return head;
    }
}