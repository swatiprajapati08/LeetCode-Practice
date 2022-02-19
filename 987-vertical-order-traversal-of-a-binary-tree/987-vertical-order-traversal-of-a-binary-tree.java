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
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> hs;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        hs = new TreeMap<>();
        DFS(root,0,0);
        
        
        
        for(Integer col : hs.keySet()){
            TreeMap<Integer,List<Integer>> curr = hs.get(col);
            List<Integer> rowAns = new ArrayList<>();
            for(Integer row : curr.keySet()){
                List<Integer> res = curr.get(row);
                Collections.sort(res);
                for(int i: res)
                    rowAns.add(i);
            }
                
                ans.add(rowAns);
        }
        return ans;
    }
     void DFS(TreeNode root,int row,int col){
    
        if(root == null) return;
      
        if(!hs.containsKey(col))
            hs.put(col,new TreeMap<>());
        
        if(!hs.get(col).containsKey(row))
        hs.get(col).put(row,new ArrayList<>());

        hs.get(col).get(row).add(root.val);
        
        DFS(root.left,row + 1,col - 1);
        DFS(root.right,row + 1,col + 1);
    }   
}