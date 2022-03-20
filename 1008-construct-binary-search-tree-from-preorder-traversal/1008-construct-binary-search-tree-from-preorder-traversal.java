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
    // O(N2)
//     public TreeNode bstFromPreorder(int[] preorder) {
//         TreeNode root = new TreeNode(preorder[0]);
//         for(int i = 1;i<preorder.length;i++)
//             add(root,preorder[i]);
//         return root;
//     }
//     //adiing to its root
//     public TreeNode add(TreeNode root, int val){
//         if(root == null)
//             return new TreeNode(val);
        
//         if(root.val > val)
//             root.left = add(root.left,val);
//         else
//             root.right = add(root.right,val);
        
//         return root;
//     }
    
    //USING RANGE O(N)
    int index = 0;
     public TreeNode bstFromPreorder(int[] preorder) {
         return bstCreation(preorder,1,1000);
     }
    
     TreeNode bstCreation(int[] preorder,int leftRange,int rightRange){
         if(index == preorder.length || leftRange > preorder[index] || rightRange <  preorder[index])
             return null;
         
         TreeNode root = new TreeNode(preorder[index++]);
         
         root.left = bstCreation(preorder,leftRange,root.val);
         root.right = bstCreation(preorder,root.val,rightRange);
         
         return root;
     }
    
}