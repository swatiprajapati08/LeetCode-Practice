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
    public int sumNumbers(TreeNode root) {
        Helper(root,"");
        return sum;
    }
    void Helper(TreeNode root,String s){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            //reached to leaf node
            // sb.append(root);
            // String s = sb.reverse().toString();
            s += root.val;
            sum += Integer.parseInt(s);
            return;
        }
        
        Helper(root.left,s+root.val+"");
        Helper(root.right,s+root.val+"");
    }
}