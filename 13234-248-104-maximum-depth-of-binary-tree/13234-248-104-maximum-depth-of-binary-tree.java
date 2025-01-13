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
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if(root == null)    return ans;

        Queue<TreeNode> st = new ArrayDeque<>();
        st.add(root);

        while(!st.isEmpty()){
            ans++;
            int size = st.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = st.poll();
                if(curr.left != null)   st.add(curr.left);
                if(curr.right != null)   st.add(curr.right);
            }   
        }

        return ans;
    }
}