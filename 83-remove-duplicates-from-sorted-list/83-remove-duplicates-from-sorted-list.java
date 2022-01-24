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
        ListNode prev = dummy;
        
        while(head != null){
          
            //first occurance
            if(prev.val != head.val){
                prev.next = head;
                prev = prev.next;
            }
            else{
                int data = prev.val;
                while(head.val != data)
                    head = head.next;
            }
            
            head = head.next;
        }
        prev.next = null;
        
        return dummy.next;
    }
}

//TIME COMPLEXITY : O(N)
//SPACE COMPLEXITY : O(1)