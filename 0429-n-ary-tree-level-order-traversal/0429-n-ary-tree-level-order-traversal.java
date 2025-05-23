/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subAns = new ArrayList<>();

            while(size > 0){
                Node curr = q.poll();

                for(Node child : curr.children){
                    q.add(child);
                }

                subAns.add(curr.val);
                
                size -= 1;
            }

            ans.add(subAns);
       }

        return ans;
    }
}