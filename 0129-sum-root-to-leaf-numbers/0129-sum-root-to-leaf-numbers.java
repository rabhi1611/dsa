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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root,int number){
        number = ((number * 10) + root.val);

        int left = -1, right = -1;

        if(root.left != null)   left = helper(root.left, number);
        if(root.right != null)   right = helper(root.right, number);

        if(left == -1 && right == -1){
            return number;
        }

        if(left == -1){
            return right;
        }

        if(right == -1){
            return left;
        }

        return left + right;
    }
}