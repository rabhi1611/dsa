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
    public int ans = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int a = helper(root.left);
        int b = helper(root.right);

        int cnt = 0;
        if(root.val >= 1){
            cnt += root.val - 1;
        } else {
            cnt -= 1;
        }

        ans += Math.abs(a) + Math.abs(b); 

        return a + b + cnt;
    }
}