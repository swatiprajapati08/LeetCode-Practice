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
    ArrayList<Integer> inorder;
    public TreeNode balanceBST(TreeNode root) {
        inorder = new ArrayList<>();
        inorder(root);
        
        return balanceBSTHelper(0,inorder.size() - 1);
    }
    //int idx = 0;
    public TreeNode balanceBSTHelper(int left,int right){
        if(left > right)
            return null;
        
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = balanceBSTHelper(left,mid - 1);
        root.right = balanceBSTHelper(mid + 1,right);
        return root;
    }
    
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}