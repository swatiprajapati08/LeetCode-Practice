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
    public TreeNode getRightMost(TreeNode left,TreeNode curr){
        while(left.right != null && left.right != curr)
            left = left.right;
        return left;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        TreeNode curr = root;
        
        while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                preorder.add(curr.val);
                curr = curr.right; // go it right side
            }
            else{
                // first get to the left k right most children
                TreeNode rightMost = getRightMost(left,curr);
                if(rightMost.right == null) // thread is not pointing to curr
                {
                    rightMost.right = curr;
                    preorder.add(curr.val); // before going to left add yourself
                    curr = curr.left;
                }else{
                    rightMost.right = null; //remove the thread
                    curr = curr.right; 
                }
            }
        }
        return preorder;
    }
}
