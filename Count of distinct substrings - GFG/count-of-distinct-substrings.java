// { Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
   public static class Node{
        Node[] children = new Node[26];
        
       
        
        public Node get(char ch){
            return children[ch - 'a'];
        }
        
        public void set(char ch){
            children[ch - 'a'] = new Node();
        }
    } 

    
   public static int countDistinctSubstring(String st)
   {
       Node root = new Node();
       int count = 1;
       for(int i=0;i<st.length();i++)
       {
           Node curr = root;
           for(int j = i;j<st.length();j++){
               if(curr.get(st.charAt(j)) == null){
                   curr.set(st.charAt(j));
                   count++;
               }
               curr = curr.get(st.charAt(j));
           }
            
       }
       
     return count;
   }
}
//tc  O(N2)