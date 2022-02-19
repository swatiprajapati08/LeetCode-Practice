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
    //or we can use arrayList
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer,Integer> hs = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        
        DFS(root,0,hs);
        for(int i:hs.keySet())
            ans.add(hs.get(i));
        
       return ans;
    }
    
    void DFS(TreeNode root,int level,TreeMap<Integer,Integer> hs){
        
        if(root == null) return;
        if(!hs.containsKey(level))
        hs.put(level,root.val);
        
        DFS(root.right,level + 1,hs);
        DFS(root.left,level + 1,hs);
        
    }
}