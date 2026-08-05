/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            int j = 1;
            Node curr1 = q.poll();
            
            if(curr1.left != null){
                q.offer(curr1.left);
            }

            if(curr1.right != null){
                q.offer(curr1.right);
            }

            while(j < size){
                Node curr2 = q.poll();

                if(curr2.left != null){
                    q.offer(curr2.left);
                }

                if(curr2.right != null){
                    q.offer(curr2.right);
                }

                curr1.next = curr2;
                curr1 = curr1.next;
                j += 1;
            }
        }

        return root; 
    }
}