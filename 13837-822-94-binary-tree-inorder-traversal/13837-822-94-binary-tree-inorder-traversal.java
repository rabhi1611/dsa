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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)    return new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        List<Integer> ans = new ArrayList<>();
        ans.addAll(left);
        ans.add(root.val); 
        ans.addAll(right);

        return ans;
    }
}