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

    private String helper(TreeNode root){
        if(root == null){
            return "";
        }
        
        String left = helper(root.left);
        String right = helper(root.right);

        // we have each node
        // check if like this node other exist?
        StringBuilder pattern = new StringBuilder();
        pattern.append(root.val).append("|").append(left).append("|").append(right);

        if(rec.containsKey(pattern.toString())){
            if(rec.get(pattern.toString()) == false){
                ans.add(root);
                rec.put(pattern.toString(), true);    
            }
        } else {
            rec.put(pattern.toString(), false);
        }

        return pattern.toString();
    }
}   