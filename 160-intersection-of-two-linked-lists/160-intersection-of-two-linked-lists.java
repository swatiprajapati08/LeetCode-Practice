/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode temp = headB;
        
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = headB; //make a cycle
        
        // Now try to find headA and headB 
        ListNode ans =  detectCycle(headA);
        
        temp.next = null;
      return ans;
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)break;
    }
    if(fast == null || fast.next == null) return null;
        
        // Distance btw head and starting point  == Distance btw meeting point and starting point 
    ListNode curr = head;
        while(curr != slow){
            curr = curr.next;
            slow = slow.next;
        }
        
        return curr;
    }
}