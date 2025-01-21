/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class NodePos {
    TreeNode node;
    Integer row;
    Integer col;

    NodePos(TreeNode node, Integer row, Integer col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)    return ans;

        Map<Integer, List<NodePos>> mp = new TreeMap<>();

        Queue<NodePos> q = new ArrayDeque<>();
        q.add(new NodePos(root, 0, 0));

        while(!q.isEmpty()){
            NodePos curr = q.poll();

            TreeNode cnode = curr.node;
            int crow = curr.row;
            int ccol = curr.col;
        
            List<NodePos> temp = mp.getOrDefault(ccol, new ArrayList<>());
            temp.add(curr);
            mp.put(ccol, temp);

            if(cnode.left != null)  q.add(new NodePos(cnode.left, crow + 1, ccol - 1)); 
            if(cnode.right != null) q.add(new NodePos(cnode.right, crow + 1, ccol + 1));
        }

        Iterator<Integer> it = mp.keySet().iterator();         
        while(it.hasNext()) {  
            int key=(int)it.next();
            List<NodePos> val = mp.get(key);
            ans.add(val.stream().sorted((a, b) -> 
            a.row.equals(b.row) ? Integer.valueOf(a.node.val).compareTo(Integer.valueOf(b.node.val))
            : a.row.compareTo(b.row)).map(a -> a.node.val).toList());
        }  

        return ans;
    }
}