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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Helper(root,targetSum,curr,res);
        return res;
    }
    
    void Helper(TreeNode root, int targetSum,ArrayList<Integer> temp,List<List<Integer>> res){
        if(root == null){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
               res.add(new ArrayList<>(temp));
            }
        }
        Helper(root.left,targetSum - root.val,temp,res);
        Helper(root.right,targetSum - root.val,temp,res);
     
        //backtrack
        temp.remove(temp.size() - 1);
    }
}