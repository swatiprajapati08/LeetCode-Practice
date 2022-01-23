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
        left.next = rightD.next;
        return leftD.next;
    }
}