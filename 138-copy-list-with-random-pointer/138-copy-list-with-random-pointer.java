/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node curr = head;
//         Insert duplicate in between
        while(curr != null){
            Node next = curr.next; //B
            Node duplicate = new Node(curr.val);  //A'
            curr.next = duplicate; //A -> A'
            duplicate.next = next; // A' -> B
            curr = duplicate.next; // A->A'->B
        }
        
        curr = head;
        while(curr != null){
           Node randomNode = curr.random;
            if(randomNode != null)
                randomNode = randomNode.next;
            curr.next.random = randomNode;
            curr = curr.next.next;
        }
       
        Node org = head;
        Node dupH = head.next;
        
        while(org != null){
            Node dup = org.next; 
        org.next = org.next.next;
            
        if(dup.next != null)
            dup.next = dup.next.next;
        
            org = org.next;
        }
        return dupH;
    }
}