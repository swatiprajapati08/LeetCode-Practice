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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res,root,"");
        return res;
    }
    
    void helper(List<String> res, TreeNode root, String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            s += root.val +"";
            res.add(s);
            return;
        }
       
        helper(res,root.left,s + root.val +"->");
        helper(res,root.right,s + root.val +"->");
        return;
    }
    
}