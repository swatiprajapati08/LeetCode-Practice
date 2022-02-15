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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // l1 = Reverse(l1);
      // l2 = Reverse(l2);
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int carry = 0,sum = 0;
        
      while(l1 != null && l2  != null) {
          sum = l1.val + l2.val + carry;
          dummy.next = new ListNode(sum % 10);
          carry = sum / 10;
          l1 = l1.next;
          l2 = l2.next;
          dummy = dummy.next;
      }
     if(l1 == null && l2 == null){
         if(carry > 0)
             dummy.next = new ListNode(carry);
         dummy = dummy.next;
     } else{
         while(l1 != null){
              sum = l1.val + carry;
              dummy.next = new ListNode(sum % 10);
              carry = sum / 10;
              l1 = l1.next;
              dummy = dummy.next;
         }
          while(l2 != null){
              sum = l2.val + carry;
              dummy.next = new ListNode(sum % 10);
              carry = sum / 10;
              l2 = l2.next;
              dummy = dummy.next;
         }
          if(carry > 0)
             dummy.next = new ListNode(carry);
         dummy = dummy.next;
     }
      // dummy.next = null;  
       return res.next; 
    }
    
    ListNode Reverse(ListNode curr){
        ListNode prev = null,next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}