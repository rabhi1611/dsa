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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)    return ans;

        Stack<TreeNode> st = new Stack<>();
        
        st.add(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ans.add(curr.val);

            if(curr.left != null)   st.add(curr.left);
            if(curr.right != null)  st.add(curr.right);
        }

        Collections.reverse(ans);

        return ans;
    }
}