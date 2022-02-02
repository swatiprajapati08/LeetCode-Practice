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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode ptr = head;
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        ListNode ptrH = null;
        while(ptr != null){
            int p = 0;
           
            //move till k
            ptrH = ptr;//save head
            while(ptr != null && p < k ){
                ptr = ptr.next;
                p++;
            }
            
            if(p == k){
            dummy.next = rev(ptrH,ptr);
            
            while(dummy.next != null)
            dummy = dummy.next;
            }
            else
            dummy.next = ptrH;
        }
        
        return res.next;
    }

    
    public static ListNode rev(ListNode head,ListNode tail){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != tail){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
