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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // using 2pointer
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        
        int count = 1;
        while(slow != null && count <= n)
        { slow = slow.next; count++;}

        while(slow.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //reeach to nth node
        fast.next = fast.next.next;
        return dummy.next;
    }
}