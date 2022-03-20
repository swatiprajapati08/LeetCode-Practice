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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode root,StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        return deserializeHelper(arr);
    }
    
    int idx = 0;
    public TreeNode deserializeHelper(String arr[]){
        if(idx >= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        idx++;
        root.left = deserializeHelper(arr);
        root.right = deserializeHelper(arr);
        return root;
            
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;