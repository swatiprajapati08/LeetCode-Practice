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
    long ans = 0;
    int Sum = 0;
    int mod = (int)Math.pow(10,9) + 7;
    public int maxProduct(TreeNode root) {
        Sum = Helper(root);
        Product(root);
        
        return (int)(ans % mod);
    }
    int Helper(TreeNode root){
        if(root == null)return 0;
        root.val += Helper(root.left) + Helper(root.right);
        return root.val;
    }
    void Product(TreeNode root){
        
        if(root == null) return;
        
        //left edge removed
        long leftSubTree = root.left == null ? 0 : root.left.val;
        long leftAns = leftSubTree * (Sum - leftSubTree); 
        
        
        //right edge removed
        long rightSubTree = root.right == null ? 0 : root.right.val;
        long rightAns = rightSubTree * (Sum - rightSubTree); 
        
        
        ans = Math.max(ans,Math.max(rightAns,leftAns));
        
        Product(root.left);
        Product(root.right);
    }
}