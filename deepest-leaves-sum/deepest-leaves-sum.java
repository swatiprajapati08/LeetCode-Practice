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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int sum = 0;
        
        while(!q.isEmpty()){
            sum = 0;
            int counter = q.size();
            for(int i = 0; i< counter;i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                
                //System.out.println(sum);
                
                if(curr.left != null ) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                //sum = currSum;
            }
        }
        return sum;
    }
}