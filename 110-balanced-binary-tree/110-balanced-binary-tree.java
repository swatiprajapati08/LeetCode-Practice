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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int left_h = height(root.left);
        int right_h = height(root.right);
        
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        
        if(left == true && right == true && Math.abs(left_h - right_h) <= 1)
            return true;
        else
            return false;
    }
    int height(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}