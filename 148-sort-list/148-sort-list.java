/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void randomize(ListNode head){
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        
        int randomIdx = (new Random()).nextInt(size);
        
        curr = head;
        while(randomIdx-- >0)
            curr =curr.next;
        
        int temp = head.val;
        head.val = curr.val;
        curr.val = temp;
        
    }
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode rightD = right;
        ListNode leftD = left;
        
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = null;
        right.next = null;
        
        return leftD.next;
    }
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;  
        
        randomize(head);
        ListNode left = sortList(partition(head,head.val));
        ListNode right = sortList(head.next);
        head.next = right;
        
        if(left == null) return head;
        
        ListNode leftTail = getTail(left);
        leftTail.next = head;
        return left;
    }
    
    public ListNode getTail(ListNode curr){
        if(curr == null) return curr;
        while(curr.next != null) curr = curr.next;
        return curr;
    }
}