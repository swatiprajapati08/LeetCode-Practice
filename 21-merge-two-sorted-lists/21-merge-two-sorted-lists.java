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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(head1 != null && head2 != null){
            if(head2.val > head1.val){
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