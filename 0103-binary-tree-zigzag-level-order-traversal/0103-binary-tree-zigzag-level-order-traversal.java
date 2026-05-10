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

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();

            while(size > 0){
                TreeNode curr = q.poll();
                ls.add(curr.val);
                
                if(curr.left != null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }
                size -= 1;
            }

            if(flag == true) {   
               Collections.reverse(ls);
               flag = false;
            } else flag = true;

            ans.add(ls);
        }

        return ans;
    }
}