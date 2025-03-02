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
    public boolean isValidBST(TreeNode root) {
        Long lr = Long.MIN_VALUE;
        Long rr = Long.MAX_VALUE;

        return helper(root, lr, rr);
    }

    private boolean helper(TreeNode node, Long lr, Long rr){
        if(node == null){
            return true;
        }

        if(!(node.val > lr && node.val < rr)){
            return false; 
        }

        boolean a = helper(node.left, lr, (long)node.val);
        boolean b = helper(node.right, (long)node.val, rr);

        return a && b;     
    }
}