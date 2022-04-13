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
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int sum = 0, carry = 0;
        
        while(l1 != null || l2 != null){
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            
            sum = value1 + value2 + carry;
            carry = sum > 9 ? sum / 10 : 0;
            ListNode temp = new ListNode(sum % 10);
            ans.next = temp;
            ans = temp;
        }
        if(carry > 0)
           ans.next = new ListNode(carry);
        return dummy.next;
    }
}