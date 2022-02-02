// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data); 
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data); 
            }
            
            Node failure = new Node(-1);
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            
            Node temp = head;
            int f = 0;
            while (temp != null) 
    		{ 
    			if(mp.get(temp) != temp.data){
    			    f = 1;
    			}
    			temp = temp.next; 
    		} 
            
            if(f==1){
                printList(failure); 
            }
            else{
                printList(head); 
            }
            t--;
        }
    } 
} 
   
// } Driver Code Ends


/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head)
    {
        return reverse(head,2);
    }
    public static Node reverse(Node node, int k)
    {
        Node ptr = node;
        Node dummy = new Node(-1);
        Node res = dummy;
        Node ptrH = null;
        while(ptr != null){
            int p = 0;
           
            //move till k
            ptrH = ptr;//save head
            while(ptr != null && p < k ){
                ptr = ptr.next;
                p++;
            }
            
            if(p == k){
            dummy.next = rev(ptrH,ptr);
            
            while(dummy.next != null)
            dummy = dummy.next;
            }
            else
            dummy.next = rev(ptrH,null);
        }
        
        return res.next;
    }

    
    public static Node rev(Node head,Node tail){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != tail){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
