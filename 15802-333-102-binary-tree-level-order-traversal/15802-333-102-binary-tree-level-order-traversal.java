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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)    return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> temp = new ArrayList<>();
            
            for(int i = 0; i < levelNum; i++){
                TreeNode currNode = q.poll();
                if(currNode.left != null)   q.add(currNode.left);
                if(currNode.right != null)  q.add(currNode.right);
                temp.add(currNode.val);
            }

            ans.add(temp);
        }

        return ans;
    }
}