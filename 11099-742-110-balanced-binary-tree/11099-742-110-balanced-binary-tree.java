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
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;

        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }

        int hl = height(root.left);
        int hr = height(root.right);

        if(Math.abs(hr - hl) > 1)   return false;

        return true;   
    }

    private int height(TreeNode root){
        if(root == null)    return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}