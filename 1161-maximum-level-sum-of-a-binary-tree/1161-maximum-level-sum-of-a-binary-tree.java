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
    HashMap<Integer,Integer> hs = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        DFS(root,1);
        int level = 0, sum = Integer.MIN_VALUE;
        
        for(int l:hs.keySet()){
            if(sum < hs.get(l)){
                sum = hs.get(l);
                level = l;
            }
        }
        return level;
    }
    void DFS(TreeNode root, int level){
        if(root == null)return;
        
        hs.put(level,hs.getOrDefault(level,0) + root.val);
        DFS(root.left,level + 1);
        DFS(root.right,level + 1);
        return;
    }
}