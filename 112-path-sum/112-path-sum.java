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
    public boolean hasPathSum(TreeNode node, int targetSum) {
        
        if(node == null)
            return false;
        targetSum -= node.val;
        if(targetSum == 0 && node.left == null && node.right == null)
            return true;
        
        boolean ans = hasPathSum(node.left,targetSum) || 
                      hasPathSum(node.right,targetSum);
        
        targetSum += node.val;
        
        if(ans == true)
            return true;
        
        return false;
    }
}