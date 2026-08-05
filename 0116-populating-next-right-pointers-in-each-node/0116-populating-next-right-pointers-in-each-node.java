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
            
            checkLeftRightChild(curr1, q);

            while(j < size){
                Node curr2 = q.poll();

                checkLeftRightChild(curr2, q);

                curr1.next = curr2;
                curr1 = curr1.next;
                j += 1;
            }
        }

        return root; 
    }

    private void checkLeftRightChild(Node node, Queue<Node> q){
        if(node.left != null){
            q.offer(node.left);
        }

        if(node.right != null){
            q.offer(node.right);
        }
    }
}