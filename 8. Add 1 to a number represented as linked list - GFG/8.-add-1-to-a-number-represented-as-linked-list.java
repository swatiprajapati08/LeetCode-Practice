// { Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        Node rev = reverse(head);
        Node curr = rev;
        Node temp = head;
        int carry = 1,sum = 0;
        while(curr!= null){
            sum = curr.data + carry;
            carry = sum >= 10 ? 1 : 0;
            curr.data = sum % 10;
            temp = curr;
            curr = curr.next;
        }
        
        if(carry != 0){
            //create a new Node
            Node n = new Node(carry);
            temp.next = n;
        }
        
        return reverse(rev);
        
    }
    
    static Node reverse(Node head){
        Node prev = null,next = null;
        Node curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    } 
}
