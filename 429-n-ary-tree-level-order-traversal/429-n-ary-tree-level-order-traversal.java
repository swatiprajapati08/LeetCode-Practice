/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// class Solution {
//     public List<List<Integer>> levelOrder(Node root) {
        
//         List<List<Integer>> res = new ArrayList<>();
        
//         if(root == null) return res;
        
//         Queue<Node> q = new ArrayDeque<>();
//         q.add(root);
        
//         while(q.size() > 0){
//             int size = q.size();
//             List<Integer> ans = new ArrayList<>();
//             for(int i = 0; i < size;i++){
//                 Node top = q.remove();
//                 ans.add(top.val);
//                 for(int j =0;j< top.children.size();j++)
//                     q.add(top.children.get(j));
//             }
//             res.add(ans);
//         }
//         return res;
//     }
// }

// Using marker
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        Node marker = new Node(-1);
        q.add(marker);
        
        List<Integer> level = new ArrayList<>();
        while(q.size() > 1){  // atlast marker node hi hoga
            Node curr = q.remove();
            if(curr == marker){
                res.add(level);
                level = new ArrayList<>();
                q.add(marker);
            }else{
                 level.add(curr.val);
                //pushing its children
                 for(Node child:curr.children)
                     q.add(child);
            }
        }
        if(level.size() > 0)
            res.add(level);
        return res;
    }
}