// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    static class Pair{
        Node parent = null;
        int leftRange = Integer.MIN_VALUE;
        int rightRange = Integer.MAX_VALUE;
        public Pair(){}
        public Pair(Node parent,int leftRange,int rightRange){
            this.parent = parent;
            this.leftRange = leftRange;
            this.rightRange = rightRange;
        }
    }
    public Node constructBST(int[] arr)
    {
       int n = arr.length;
       LinkedList<Pair> q = new LinkedList<>();
       q.add(new Pair());
       Node root = null;
       int i = 0;
       while(q.size() > 0 && i < n){
           Pair rem = q.removeFirst();
           int ele = arr[i];
           
           // not lies in range
           if(ele < rem.leftRange || ele > rem.rightRange) continue;
           
           Node node = new Node(ele);
           i++;
           if(rem.parent == null)
           root = node;
           else{
               Node parent = rem.parent;
               if(ele <= parent.data){
                   parent.left = node;
               }else{
                   parent.right = node;
               }
           }
           
           q.addLast(new Pair(node,rem.leftRange,ele));
           q.addLast(new Pair(node,ele,rem.rightRange));
       }
       return root;
    }
}