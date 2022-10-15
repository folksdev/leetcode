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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int count = 0;
        ListNode result = head;
        ListNode temp = head;
        while (temp != null) {
            count += 1;
            temp = temp.next;
        }

        int middle = count / 2;
        

        for (int i = 0; i < middle- 1; i++) {
            result = result.next;
        }
        result.next = result.next.next;
        return head;
    }
    
    
    
}