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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for(int i = 0; i < k; i++){
            if(lists[i] != null)
                pq.offer(lists[i]);
        }

        ListNode ans = null, temp = null;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(ans == null){
                ans = new ListNode(curr.val);
                temp = ans;
            } else {
                temp.next = new ListNode(curr.val);
                temp = temp.next;
            }
            curr = curr.next;
            if(curr != null)
                pq.offer(curr);
        }

        return ans;
    }
}