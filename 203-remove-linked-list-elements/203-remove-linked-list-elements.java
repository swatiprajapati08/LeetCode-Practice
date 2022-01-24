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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(head != null){
            if(head.val == val)
                head = head.next;
            else{
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            }
        }
        dummy.next = null;
        return res.next;
    }
}