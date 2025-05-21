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
class Solution {

    private Map<String, Boolean> rec = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();
        
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return ans;
    }

    private void helper(TreeNode root){
        if(root == null){
            return;
        }


        // we have each node
        // check if like this node other exist?
        StringBuilder pattern = new StringBuilder();
        traverse(root, pattern);

        if(rec.containsKey(pattern.toString())){
            if(rec.get(pattern.toString()) == false){
                ans.add(root);
                rec.put(pattern.toString(), true);    
            }
        } else {
            rec.put(pattern.toString(), false);
        }

        helper(root.left);
        helper(root.right);

        return;
    }

    private void traverse(TreeNode root, StringBuilder pattern){
        if(root == null){
            return;
        }

        pattern.append(root.val);

        if(root.left != null){
            pattern.append("L"); 
        }

        traverse(root.left, pattern); 

        if(root.right != null){
            pattern.append("R");  
        }

        traverse(root.right, pattern);

        return;
    }
}   