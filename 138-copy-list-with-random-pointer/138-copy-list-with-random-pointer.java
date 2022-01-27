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
        
        HashMap<Node,Node> hm = new HashMap<>();
        //add All Nodes
        Node head2 = new Node(-1);
        Node original = head;
        Node tail = head2;
        
        //creation of deep copy
        while(original != null){
            Node duplicate = new Node(original.val);
            tail.next = duplicate;
            
            
            hm.put(original,duplicate);
            tail = duplicate;
            original = original.next;
        }
        
        //updating random pointer
        original = head;
        while(original != null){
            Node randomNode = original.random;
            
            if(randomNode != null){
               randomNode = hm.get(randomNode); 
            }
            hm.get(original).random = randomNode;
            original = original.next;
        }
        return head2.next;
    }
}