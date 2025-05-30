/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private void fillMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> mp){
        if(root == null){
            return;
        }

        mp.put(root, parent);
        
        fillMap(root.left, root, mp);
        fillMap(root.right, root, mp);

        return;
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        if(target == null){
            return ans;
        }

        Map<TreeNode, TreeNode> mp = new HashMap<>();
        fillMap(root, null, mp);

        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i += 1){
                TreeNode curr = q.poll();
 
                if(level == k){
                    ans.add(curr.val);
                }

                if(!visited.contains(curr.left) && curr.left != null){
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if(!visited.contains(curr.right) && curr.right != null){
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                if(mp.containsKey(curr) && mp.get(curr) != null && !visited.contains(mp.get(curr))){
                    q.add(mp.get(curr));
                    visited.add(mp.get(curr));
                }
            }

            level += 1;
        }

        return ans;
    }
}