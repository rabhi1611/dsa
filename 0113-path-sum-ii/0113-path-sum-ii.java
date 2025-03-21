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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(new ArrayList<>(), 0, root, targetSum);
        return ans;
    }

    private void helper(List<Integer> ls, int csum, TreeNode root, int targetSum){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){    
            ls.add(root.val);
            csum += root.val;
            if(csum == targetSum){
                ans.add(new ArrayList<>(ls));
            }
            ls.remove(ls.size() - 1);
            return;
        }

        ls.add(root.val);
        helper(ls, csum + root.val, root.left, targetSum);
        helper(ls, csum + root.val, root.right, targetSum);

        ls.remove(ls.size() - 1);
        return;
    }
}