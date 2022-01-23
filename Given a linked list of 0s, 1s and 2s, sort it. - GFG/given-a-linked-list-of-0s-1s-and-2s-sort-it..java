// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        int count0 =0,count1 = 0,count2 = 0;
        Node zeroD = zero;
        Node oneD = one;
        Node twoD = two;
        while(head != null){
            if(head.data == 0){
                zero.next = head;
               
                zero = zero.next;
            }
            else if(head.data == 1){
                one.next = head;
               
                one = one.next;
            }else{
                two.next = head;
              
                two = two.next;
            }
            head = head.next;
        }
        two.next = null;
        one.next = null;
        zero.next = null;
        
        one.next = twoD.next;
        zero.next = oneD.next;
        
        return zeroD.next;
    }
}


