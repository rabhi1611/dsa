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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)    return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()){
            int lm = q.size();
            List<Integer> t = new ArrayList<>(Collections.nCopies(lm, 0));
            for(int i = 0; i < lm; i++){
                TreeNode curr = q.poll();
                int idx = ans.size() % 2 == 0 ? i : lm - 1 - i;
                t.set(idx, curr.val);
                if(curr.left != null)   q.add(curr.left);
                if(curr.right != null)   q.add(curr.right);
            }

            ans.add(t);
        }

        return ans;
    }
}