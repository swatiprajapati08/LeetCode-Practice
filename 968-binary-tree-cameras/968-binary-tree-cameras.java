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

// if node has camera = 0
// if node has covered = 1
// if node need camera = -1
class Solution {
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if(minCameraCoverHelper(root) == -1)
            cameras++;
        return cameras;
    }
    public int minCameraCoverHelper(TreeNode root){
        
        // null covered man lo
        if(root == null) return 1;
        
        int left = minCameraCoverHelper(root.left);
        int right = minCameraCoverHelper(root.right);
        
        // any of child need camera
        if(left == -1 || right == -1){
            cameras++;
            return 0; 
        }
        // any of child have camera so we are already covered
        if(left == 0 || right == 0){
            return 1;
        }
        
        // left = 1 and right = 1 means they are already covered and they dont have camera also , but i need camera
        return -1;
    }
}