// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}// } Driver Code Ends


//User function Template for Java


class Solution {
    static class Node implements Comparable<Node>{
        char ch;
        int freq;
        Node right;
        Node left;
        Node(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
            this.right = null;
            this.left = null;
        }
        
        public int compareTo(Node other){
            if(this.freq == other.freq){
                return 1;
            }
            return this.freq - other.freq;
        }
    }
    static ArrayList<String> encoding;
    public void preorder(Node root,String str){
        
        if(root == null) return;
        if(root.left == null && root.right == null){
            encoding.add(str);
            return;
        }
        preorder(root.left, str +"0");
        preorder(root.right, str +"1");
        
    }
    
    
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
       PriorityQueue<Node> q = new PriorityQueue<>();
       for(int i = 0;i<N;i++){
           q.add(new Node(S.charAt(i),f[i]));
        }
        
        while(q.size() > 1){
            Node left = q.remove();
            Node right = q.remove();
            
            Node root = new Node('#',left.freq + right.freq);
            root.left = left;
            root.right = right;
            
            q.add(root);
        }
        Node root = q.remove();
        encoding= new ArrayList<>();
        preorder(root,"");
        
        return encoding;
    }
}