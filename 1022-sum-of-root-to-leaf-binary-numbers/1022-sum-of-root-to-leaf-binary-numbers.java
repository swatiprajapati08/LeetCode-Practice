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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        Helper(root,"");
        return sum;
    }
    public void Helper(TreeNode root,String s){
        if(root.left == null && root.right == null){
            s+= root.val;
            sum += Integer.parseInt(s,2);
            return;
        }
        if(root.left != null)
            Helper(root.left , s + root.val+"");
        
        if(root.right != null)
            Helper(root.right , s + root.val+"");
    }
}