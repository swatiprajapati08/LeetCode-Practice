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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        
        ListNode p = head;
        int size = 1;
        while(p.next != null){
            size++;
            p = p.next;
        }
        k = k % size;
        
        if(k == 0)
            return head;
        
        ListNode curr = head;
        
        for(int i = 0;i< size - k - 1;i++)
            curr = curr.next;
        
        ListNode newHead = curr.next;
        curr.next = null;
        p.next = head;
        
        return newHead;
    }
}