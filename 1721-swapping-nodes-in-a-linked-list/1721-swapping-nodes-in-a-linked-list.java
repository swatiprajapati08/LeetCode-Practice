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
    public ListNode swapNodes(ListNode head, int k) {
        int p = k;
        ListNode temp = head;
        int n = 0;
        ListNode ptr = head;
        // count whole node
        while(ptr != null){
            ptr = ptr.next;
            n++;
        }
        while(p-- > 1 && temp.next != null)
            temp = temp.next;
        //System.out.println(n +" "+temp.val);
        
        ListNode slow = head;
        
        int i = 1;
        while(i <= (n - k) && slow.next != null)
        {slow = slow.next;
         i++;}
        
         //System.out.println(slow.val);
        
        int temp2 = slow.val;
        slow.val = temp.val;
        temp.val = temp2;
        return head;
    }
}