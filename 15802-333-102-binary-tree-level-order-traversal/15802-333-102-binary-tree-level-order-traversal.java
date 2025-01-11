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

class Pair {
    public TreeNode node;
    public Integer level;

    Pair(TreeNode node, Integer level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Map<Integer, List<Integer>> mp = new LinkedHashMap<>();

        if(root == null)    return ans;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode currNode = curr.node;
            Integer currLevel = curr.level;

            List<Integer> temp = mp.getOrDefault(currLevel, new ArrayList<>());
            temp.add(currNode.val);

            mp.put(currLevel, temp);

            if(currNode.left != null)   q.add(new Pair(currNode.left, currLevel + 1));
            if(currNode.right != null)  q.add(new Pair(currNode.right, currLevel + 1));
        }

        ans = mp.entrySet().stream().map(a -> a.getValue()).toList();

        return ans;
    }
}