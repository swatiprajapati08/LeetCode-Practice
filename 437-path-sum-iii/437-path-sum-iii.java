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
    int count = 0,sum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        HashMap<Integer,Integer> hs = new HashMap<>();
        hs.put(0,1);
        
        hasPathSum(root,targetSum,hs);
        
        return count;
    }
    public void hasPathSum(TreeNode root, int targetSum,HashMap<Integer,Integer> hs) {
        if(root == null)return;
        
        sum += root.val;
        
        if(hs.containsKey(sum - targetSum))
            count += hs.get(sum - targetSum);
        
        hs.put(sum,hs.getOrDefault(sum,0) + 1);
        
        hasPathSum(root.left,targetSum,hs);
        hasPathSum(root.right, targetSum,hs);
          hs.put(sum,hs.get(sum) - 1);
        sum -= root.val;
        return;
    }
    
}