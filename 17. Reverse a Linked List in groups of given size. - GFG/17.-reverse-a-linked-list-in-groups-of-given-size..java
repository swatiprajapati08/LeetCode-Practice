// { Driver Code Starts
import java.util.*;
import java.lang.*;

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

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}

// } Driver Code Ends


/*node class of the linked list

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

class Solution
{
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
                // System.out.print(ptr.data);
                ptr = ptr.next;
                p++;
            }
            if(p == k){
            dummy.next = rev(ptrH,ptr);
            
            while(dummy.next != null)
            dummy = dummy.next;
            //dummy = ptr;
            }
            else
            dummy.next = rev(ptrH,null);
        }
        //dummy.next = rev(ptr,null);
        return res.next;
    }
    
    public static  void display(Node head){
        while(head != null){
            System.out.print(head.data +"->");
            head = head.next;
        }
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
        // display(prev);
        return prev;
    }
}

