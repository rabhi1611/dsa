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
    public void reorderList(ListNode head) {
        helper(head);
    }


    private void helper(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        int n = length(head);
        //System.out.println(n);
        int run = n - (n / 2);
        //System.out.println(run);
        Stack<ListNode> st = new Stack<>();
        fillStack(st, head, run);
        //System.out.println(st.size());

        // code
        solve(head, st);
    }
    
    
    private void solve(ListNode head, Stack<ListNode> st){
        while(head != null){
            if(st.isEmpty()){
                break;
            }
            ListNode temp = head.next;
            head.next = st.pop();
            head.next.next = temp;
            head = head.next.next;
        }
    }
    

    private void fillStack(Stack<ListNode> st, ListNode head, int run){
        ListNode prev = null;
        while(head != null){
            if(run == 0){
                prev.next = null;
                break;
            }

            run -= 1;
            prev = head;
            head = head.next;        
        }

        //System.out.println(head.val);

        while(head != null){
            ListNode pre = head;
            st.add(head);
            head = head.next;
            pre.next = null;
        }
    }

    private int length(ListNode head){
        int cnt = 0;

        while(head != null){
            cnt += 1;
            head = head.next;
        }

        return cnt;
    }
}