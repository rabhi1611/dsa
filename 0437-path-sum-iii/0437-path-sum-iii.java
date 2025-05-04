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

    Map<Long, Integer> mp = new HashMap<>();
    private int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0L);
        return ans;    
    }

    private void helper(TreeNode root, int targetSum, Long preSum){
        if(root == null){
            return;
        }

        preSum += root.val;

        if(mp.containsKey(preSum - targetSum)){
            ans += mp.get(preSum - targetSum);
        }

        if(preSum == targetSum){
            ans += 1;
        }

        mp.put(preSum, mp.getOrDefault(preSum, 0) + 1);

        helper(root.left, targetSum, preSum);
        helper(root.right, targetSum, preSum);

        mp.put(preSum, mp.get(preSum) - 1);
        preSum -= root.val;
    }
}