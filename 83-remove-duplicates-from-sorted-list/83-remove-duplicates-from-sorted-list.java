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
        if (head == null) return null;
        ListNode result = newNode(head.val);
        
        while (head.next != null) {
            int current = head.val;
            head = head.next;
            if (head.val != current) {
                result = insertEnd(result, head.val);
            }
        }
        return result;
    }
    
    public ListNode newNode(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = null;
        return node;
    }
    
    public ListNode insertEnd(ListNode result, int val) {
        if (result == null) {
            return newNode(val);
        } else {
            result.next = insertEnd(result.next, val);
        }

        return result;
    }
}