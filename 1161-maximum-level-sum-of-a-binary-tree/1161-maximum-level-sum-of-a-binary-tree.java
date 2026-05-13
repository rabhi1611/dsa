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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevelSumLevel = 1;
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();

            int levelSum = 0;
            while(size > 0){
                TreeNode curr = q.poll();
                levelSum += curr.val;

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }

                size -= 1;
            }

            if(levelSum > maxLevelSum){
                maxLevelSum = levelSum;
                maxLevelSumLevel = level;
            }

            level += 1;
        }

        return maxLevelSumLevel;
    }
}