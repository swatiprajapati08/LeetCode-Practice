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
    public int maxPathSum(TreeNode root) {
        int sum =Integer.MIN_VALUE ;
        int array[] = {sum};
        findMaxSum(root,array);
        return array[0];
    }
    int findMaxSum(TreeNode node,int res[])
    {
       if(node == null)
       return 0;
       
       int l = findMaxSum(node.left,res);
       int r = findMaxSum(node.right,res);
       
       l = l < 0 ? 0: l;
       r = r < 0 ? 0: r;
       
       int temp = Math.max(Math.max(l,r) + node.val, node.val);
       int ans = Math.max(Math.max(node.val,l+r+node.val),temp);
       
       res[0] =Math.max(ans,res[0]);
       
       return temp;
    }
}