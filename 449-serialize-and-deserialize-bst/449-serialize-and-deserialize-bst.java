/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
     static class Pair{
         TreeNode root;
         int child;
         Pair(TreeNode root){
             this.root = root;
             this.child = 0;
         }
     } 

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "null,") return null;
        String[] tokens = data.split(",");
        
        Stack<Pair> st = new Stack<>();
       
        TreeNode root = null;
        int index = 1;
        for(String s: tokens){
         
           if(s.equals("null") == true){
               if(st.peek().child == 0)
                   st.peek().child = 1;
               else st.pop();
           }
           else{
                TreeNode child = new TreeNode(Integer.parseInt(s));
               if(st.isEmpty())
                   root = child;
               else{
                    if(st.peek().child == 0){
                        st.peek().root.left = child;
                        st.peek().child = 1;
                    }else {
                        st.peek().root.right = child;
                        st.pop(); // pop that
                    }
               }
                st.push(new Pair(child));
        }
        }
        return root;
        // return null;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;