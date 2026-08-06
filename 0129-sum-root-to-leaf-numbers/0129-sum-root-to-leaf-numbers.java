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
        helper(root, new StringBuilder());
        return sum;
    }

    private void helper(TreeNode root, StringBuilder st){
        if(root.left == null && root.right == null){
            st.append(root.val);
            System.out.println(Integer.valueOf(st.toString()));
            sum += Integer.valueOf(st.toString());
            st.setLength(st.length() - 1);
            return;
        }

        st.append(root.val);
        if(root.left != null)   helper(root.left, st);
        if(root.right != null)   helper(root.right, st);
        
        if(st.length() > 0) st.setLength(st.length() - 1);
    }
}