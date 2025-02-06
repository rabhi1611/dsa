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

    private int helper(TreeNode root, int ans){
    
        if(root == null)    return 0;
        
        ans = ((ans * 10) + root.val);

        if(root.left == null && root.right == null){
            return ans;
        }

        return helper(root.left, ans) + helper(root.right, ans);
    }


    public int sumNumbers(TreeNode root) {
        return helper(root,  0);
    }
}