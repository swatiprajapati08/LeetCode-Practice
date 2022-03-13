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

    public int rangeSumBST(TreeNode root, int low, int high) {
      if (root == null)
            return 0;
 
 
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        int sum = 0;
        
        while (curr != null || s.size() > 0)
        {
            while (curr !=  null)
            {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            
            if(curr.val >= low && high >= curr.val)
                 sum += curr.val;
            
            curr = curr.right;
        }
        return sum;
    }
}