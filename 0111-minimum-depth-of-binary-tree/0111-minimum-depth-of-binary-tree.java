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

    private int helper(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = helper(root.left);
        int rightMin = helper(root.right);

        if(leftMin == Integer.MAX_VALUE && rightMin == Integer.MAX_VALUE){
            return 1;
        }

        return 1 + Math.min(leftMin, rightMin);
    }

    public int minDepth(TreeNode root) {
        int ans = helper(root);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}