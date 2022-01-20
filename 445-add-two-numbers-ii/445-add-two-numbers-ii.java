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
       ListNode first = reverse(l1);
        ListNode second = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode tempHead = dummy;
        
        while(first != null || second != null)
        {
            int val1 = first != null ? first.val : 0;
            int val2 = second != null ? second.val : 0;
            
           if(first != null) 
                first = first.next;
            if(second != null) 
                second= second.next;
            
            int sum = val1 + val2 + carry;
            
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            
           // System.out.println(sum+" "+carry+" "+temp.val);
            
            dummy.next = temp;
            dummy = dummy.next;
        }
        
        if(carry > 0)
        {
         dummy.next = new ListNode(carry);
        }
        return reverse(tempHead.next);  
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode next = null,prev = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}