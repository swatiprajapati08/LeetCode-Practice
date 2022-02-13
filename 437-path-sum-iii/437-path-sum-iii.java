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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
       return hasPathSum(root,targetSum) +  pathSum(root.left,targetSum) +                pathSum(root.right,targetSum);
    }
    public int hasPathSum(TreeNode root, int targetSum) {
        if(root ==  null)
            return 0;
        targetSum -= root.val;
        int count = 0;
        if(targetSum == 0)
            count++;
        
      return  count + hasPathSum(root.left,targetSum) +  hasPathSum(root.right, targetSum);
    }
    
}