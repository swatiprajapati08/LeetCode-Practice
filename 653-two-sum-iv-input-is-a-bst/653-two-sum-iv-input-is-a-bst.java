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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        getAll(root,ans);
        HashSet<Integer> hs = new HashSet<>();
        for(int i:ans){
            if(hs.contains(k-i))
                return true;
            hs.add(i);
        }
        return false;
    }
    void getAll(TreeNode root,ArrayList<Integer> pre){
        if(root == null) return;
        pre.add(root.val);
        getAll(root.left,pre);
        getAll(root.right,pre);
    }
}