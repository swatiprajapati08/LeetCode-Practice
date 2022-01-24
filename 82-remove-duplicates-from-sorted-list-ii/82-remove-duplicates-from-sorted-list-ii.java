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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        ListNode tail = dummy;
        ListNode curr = head;
        
        while(head != null){
            
            if(head.next == null || head.val != head.next.val){
                tail.next = head;
                tail = head;
                head = head.next;
            }
            else{
                int temp = head.val;
                while(head != null && temp == head.val)
                    head = head.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}