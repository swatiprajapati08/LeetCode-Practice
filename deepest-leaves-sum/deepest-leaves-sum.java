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
        
//         DFS
        
    int deepest = 0,sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        DS(root,0);
        return sum;
    }
    void DS(TreeNode root, int depth){
        if(root == null)return;
        
        if(deepest == depth) 
            sum += root.val;
        
        
        else if(deepest < depth){
            sum = root.val;
            deepest = depth;
        }
        DS(root.left,depth + 1);
        DS(root.right,depth + 1);
    }
        return sum;
    }
}
