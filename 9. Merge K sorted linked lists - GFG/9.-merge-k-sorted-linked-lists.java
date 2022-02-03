// { Driver Code Starts
import java.util.*;

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


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends


/*class Node
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

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        return helper(arr,0,K-1);
    }
    
    Node helper(Node[] arr,int left, int right){
        if(left > right) return null;
        if(left == right) return arr[right];
        
        int mid = (left + right) / 2;
        
        Node l1 = helper(arr,left,mid);
        Node l2 = helper(arr,mid+1,right);
        
        return merge2sortedArray(l1,l2);
    }
    
    Node merge2sortedArray(Node l1,Node l2){
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.data > l2.data){
                dummy.next = l2;
                l2 = l2.next;
            }else{
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        
        if(l1 != null)
        dummy.next = l1;
        if(l2 != null)
        dummy.next = l2;
        
        return res.next;
    }
}
