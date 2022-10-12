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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        ListNode result = null;
        int i = 0;
        while (temp != null) {
            if (i != count - n){
                result = insertEnd(result, temp.val);
            }
            temp = temp.next;
            i++;
        }
        
        return result;
    }
    
    static ListNode newNode(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = null;
        return node;
    }
    
    public static ListNode insertEnd(ListNode result, int val) {
        if (result == null) {
            return newNode(val);
        } else {
            result.next = insertEnd(result.next, val);
        }

        return result;
    }
}