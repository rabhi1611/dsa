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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }

        List<ListNode> bkp = new ArrayList<>();

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            if(curr.val < x){
                // remove
                if(prev == null){
                    head = head.next;
                    curr.next = null;
                    bkp.add(curr);
                    curr = head;
                    continue;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    bkp.add(curr);
                    curr = prev.next;
                }
            }else {
                prev = curr;
                curr = curr.next;
            }
        }


        ListNode ans = null;
        ListNode itr = null;

        for(ListNode node: bkp){
             //System.out.println(node.val);
            if(itr == null){
                itr = node;
                ans = itr;
            } else {
                itr.next = node;
                itr = itr.next;
            }
        }

        if(ans != null){
            //System.out.println(ans.val);
            itr.next = head;
            return ans;
        } else {
            return head;
        }
    }
}