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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode tree = null;

        for(int node: preorder){
            tree = helper(tree, node);
           // System.out.println(tree.val);
        }

        return tree;
    }


    private TreeNode helper(TreeNode tree, int val){
        if(tree == null){
            return new TreeNode(val);
        }

        if(val <= tree.val){
            tree.left = helper(tree.left, val);
        } else {
            tree.right = helper(tree.right, val);
        }

        return tree;
    }
}