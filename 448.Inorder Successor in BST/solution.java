public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    TreeNode succ = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
        return succ;

         //value is greater 
        if(root.val > p.val){
            succ = root;
            //go it left for more value(immediate greater value)
            return inorderSuccessor(root.left,p);
        }else
        return inorderSuccessor(root.right,p);

    }
}
