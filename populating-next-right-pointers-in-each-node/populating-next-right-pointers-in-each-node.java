/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> q = new ArrayDeque<>();
        //pushing the root
        // root.next = null;
        q.add(root);
        while(!q.isEmpty()){
            int counter = q.size();
            for(int i = 0;i < counter;i++){
                Node curr = q.poll();
                //last node
                if(i + 1 < counter)
                    curr.next = q.size() > 0 ? q.peek() : null;
                else
                    curr.next = null;
                
               if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return root;
    }
}