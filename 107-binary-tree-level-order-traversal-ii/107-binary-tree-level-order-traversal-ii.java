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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       if(root == null) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            List<Integer> list = new ArrayList<Integer>(); 
            int size = q.size();
            for(int i =0; i<size ;i++)
            {
                TreeNode curr = q.remove();
                list.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans; 
    }
}