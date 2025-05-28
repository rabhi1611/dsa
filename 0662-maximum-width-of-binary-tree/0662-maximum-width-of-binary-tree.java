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

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x){
        this.val = x;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(root, 0));

        int ans = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int startPoint = queue.peek().getValue(), endPoint = 0;

            for(int i = 0; i < size; i++){
                Pair<TreeNode, Integer> entry = queue.poll();
                TreeNode node = entry.getKey();
                endPoint = entry.getValue();

                if(node.left != null)   queue.add(new Pair<>(node.left, (2 * endPoint)));
                if(node.right != null)  queue.add(new Pair<>(node.right, (2 * endPoint) + 1));
            }

            ans = Math.max(ans, endPoint - startPoint + 1);
        }

        return ans;
    }
}