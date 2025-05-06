/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }

        Node subNextAns = flatten(head.next);
        Node subChildAns = flatten(head.child);

        if(subChildAns != null){
            head.next = subChildAns;
            subChildAns.prev = head;

            Node tailSubChildAns = subChildAns;
            
            while(tailSubChildAns.next != null){
                tailSubChildAns = tailSubChildAns.next;
            }

            tailSubChildAns.next = subNextAns;
            if(subNextAns != null)
                subNextAns.prev = tailSubChildAns;

            head.child = null;
        }

        return head;
    }
}