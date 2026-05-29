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
        int n = 0;
        
        ListNode temp1 = head;
        while(temp1 != null){
            n += 1;
            temp1 = temp1.next;
        }

        //System.out.println(n);

        if(n == 1){
            return true;
        }

        int mid = n / 2;
        //System.out.println(mid);

        temp1 = head;
        while(mid > 1){
            temp1 = temp1.next;
            mid -= 1;
        }

        ListNode temp3 = temp1;

        if(n % 2 != 0){
            temp1 = temp1.next.next;
        } else {
            temp1 = temp1.next;
        }

        temp3.next = null;

        //System.out.println(temp1.val);
        ListNode temp2 = head;

        // reverse temp1;
        temp1 = reverse(temp1);
        //System.out.println(temp1.val);

        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            //System.out.printf("%d %d \n", temp1.val, temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        //if(temp1 != null){
          //  System.out.printf("t1 %d  \n", temp1.val);
        //}

        //if(temp2 != null){
          //  System.out.printf("t2 %d  \n", temp2.val);
        //}

        if(temp1 == null && temp2 == null){
            return true;
        }

        return false;
    }

    private ListNode reverse(ListNode temp1){
        if(temp1 == null || temp1.next == null){
            return temp1;
        }

        ListNode t = temp1.next;
        ListNode sub = reverse(temp1.next);

        t.next = temp1;
        temp1.next = null;
        return sub;
    }
}