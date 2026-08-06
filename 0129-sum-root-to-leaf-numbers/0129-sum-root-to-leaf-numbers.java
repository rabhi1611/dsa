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

    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root,int number){
        if(root.left == null && root.right == null){
            number = ((number * 10) + root.val);
            sum += number;
            return;
        }

        number = ((number * 10) + root.val);
        if(root.left != null)   helper(root.left, number);
        if(root.right != null)   helper(root.right, number);

        return;
    }
}