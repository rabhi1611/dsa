/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers, both starting at the head of the list.
        ListNode slow = head;
        ListNode fast = head;
        
        // Step 1: Move the 'fast' pointer 'n' steps ahead.
        // This creates a gap of exactly 'n' nodes between 'slow' and 'fast'.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // Step 2: Handle the edge case.
        // If 'fast' is null after moving 'n' steps, it means 'n' is equal to the 
        // total length of the list. Therefore, we need to remove the first node (head).
        // We simply return 'head.next', effectively skipping the first node.
        if (fast == null) {
            return head.next;
        }
        
        // Step 3: Maintain the gap and move both pointers together.
        // Advance both 'slow' and 'fast' one step at a time until 'fast' reaches the last node.
        // Because of the 'n' node gap, when 'fast' is at the last node,
        // 'slow' will stop EXACTLY one node before the target node that needs to be deleted.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // Step 4: Delete the target node.
        // 'slow.next' is the node we want to delete. By setting 'slow.next' to 'slow.next.next',
        // we make 'slow' point directly to the node after the target, skipping it entirely.
        slow.next = slow.next.next;
        
        // Return the modified list's head.
        return head;
    }
}