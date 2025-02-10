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
    int prev = -100000, min = 100000;

    private int traverse(TreeNode root){
        if(root == null)    return min;

        traverse(root.left);
        min = Math.min(min, root.val - prev);
        prev = root.val;
        traverse(root.right);

        return min;
    }

    public int getMinimumDifference(TreeNode root) {
        return traverse(root);
    }
}