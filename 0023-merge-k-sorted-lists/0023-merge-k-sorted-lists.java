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

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            Comparator.comparing((ListNode ln) -> ln.val)
        );

        for(int i = 0; i < k; i += 1){
            if(lists[i] != null)
                pq.offer(lists[i]);
        }

        ListNode ans = null, temp = null;

        while(!pq.isEmpty()){
            ListNode curr = pq.poll();

            if(ans == null){
                ans = curr;
                temp = ans;
            }else{
                temp.next = curr;
                temp = temp.next;
            }

            curr = curr.next;
            if(curr != null){
                pq.offer(curr);
            }
        }

        return ans;
    }
}