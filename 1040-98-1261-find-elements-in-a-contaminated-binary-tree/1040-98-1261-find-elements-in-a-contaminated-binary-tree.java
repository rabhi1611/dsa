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
class FindElements {

    private final TreeNode node;
    private final Set<Integer> st;

    private void helper(TreeNode root, Integer prev, int dir){
        if(root == null){
            return;
        }
        
        if(dir == 0){
            root.val = 0;
        } else if(dir == -1){
            // left
            root.val = ((2 * prev) + 1);
        } else if (dir == 1){
            // right
            root.val = ((2 * prev) + 2);
        }

        st.add(root.val);

        helper(root.left, root.val, -1);
        helper(root.right, root.val, +1);

        return;
    }

    public FindElements(TreeNode root) {
        this.node = root;
        this.st = new HashSet<>();
        helper(node, null, 0);
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */