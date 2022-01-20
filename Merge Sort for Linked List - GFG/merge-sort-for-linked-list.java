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
		   
		      head = new Solution().mergeSort(head);
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
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
       if(head == null|| head.next == null) return head;
       
    //   find mid
    
    Node slow = head;
    Node fast = head;
    Node prev = null;
    
    while(fast != null && fast.next != null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    
    prev.next = null;
    
    Node left = mergeSort(head);
    Node right = mergeSort(slow);
       
     return sortedMerge(left,right);
    }
    
    
    static Node sortedMerge(Node head1, Node head2) {
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;
    
        Node dummy = new Node(-1);
        Node res = dummy;
        while(head1 != null && head2 != null){
            if(head2.data > head1.data){
                dummy.next = head1;
                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        
        if(head1 != null)
        dummy.next = head1;
        
        if(head2 != null)
        dummy.next = head2;
        
        return res.next;
   } 
}


