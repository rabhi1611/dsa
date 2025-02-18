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
    Map<Integer, Integer> mp = new HashMap<>();

    private void fun(int[] idx, int l, int r, int[] inorder, int[] postorder, TreeNode tree, int flag){
        if(idx[0] < 0){
            return;
        }

        if(l > r){
            idx[0] += 1;
            return;
        }

        int mid = mp.get(postorder[idx[0]]);
        TreeNode prev = tree;
        if(flag == -1){
            tree.left = new TreeNode(postorder[idx[0]]);
            tree = tree.left;
        } else if (flag == 1){
            tree.right = new TreeNode(postorder[idx[0]]);
            tree = tree.right;
        }

        idx[0] -= 1;
        fun(idx, mid + 1, r, inorder, postorder, tree, 1);
        idx[0] -= 1;
        fun(idx, l, mid - 1, inorder, postorder, tree, -1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        for(int i = 0 ; i < n; i++){
            mp.put(inorder[i], i);
        }
        
        TreeNode tree = new TreeNode(postorder[n - 1]);
        int[] idx = new int[1];
        idx[0] = n - 1;
        fun(idx, 0, n - 1, inorder, postorder, tree, 0);
        return tree;
    }
}