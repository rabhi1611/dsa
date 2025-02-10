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

    private void traverse(TreeNode root, List<Integer> ls){
        if(root == null)    return;

        ls.add(root.val);
        traverse(root.left, ls);
        traverse(root.right, ls);

        return;
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        traverse(root, ls);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < ls.size(); i++){
            for(int j = i + 1; j < ls.size(); j++){
                min = Math.min(min, Math.abs(ls.get(j) - ls.get(i)));
            }
        }

        return min;
    }
}