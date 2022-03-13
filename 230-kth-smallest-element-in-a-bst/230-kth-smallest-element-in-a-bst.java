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
    int val;
    public int kthSmallest(TreeNode root, int k) {
         val = k;
        return kthSmallerHelper(root);
    }
    
    int kthSmallerHelper(TreeNode root){
        if(root == null)
            return -1;
        
        int ans = kthSmallerHelper(root.left);
        if(ans != -1)
            return ans;
        
        val--;
        if(val == 0)
            return root.val;
        
        ans = kthSmallerHelper(root.right);
        return ans;
    }
}