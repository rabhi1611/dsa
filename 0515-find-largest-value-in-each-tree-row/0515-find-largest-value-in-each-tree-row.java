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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int maxEachRow = Integer.MIN_VALUE;
            
            int size = q.size();
            while(size > 0){
                TreeNode curr = q.poll();
                maxEachRow = Math.max(maxEachRow, curr.val);

                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }

                size -= 1;
            }

            ans.add(maxEachRow);
        }  

        return ans;
    }
}