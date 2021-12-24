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
    public void reorderList(ListNode head) {
        //ind median
        
        ListNode ptr1 = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        // System.out.println(temp.val);
        
        ListNode ptr2 = reverse(temp);
        
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        int k = 0;
        while(ptr1!=null && ptr2!=null){
            if(k % 2 == 0){
                dummy.next = ptr1;
                ptr1 = ptr1.next;
            }
            else{
                dummy.next = ptr2;
                ptr2 = ptr2.next;
            }
            dummy = dummy.next;
            k++;
        }
        while(ptr1 != null){
            dummy.next = ptr1;
            ptr1 = ptr1.next;
            dummy = dummy.next;
        }
         while(ptr2 != null){
            dummy.next = ptr2;
            ptr2 = ptr2.next;
            dummy = dummy.next;
        }
        head = res.next;
    }
    
    ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}