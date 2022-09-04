import java.util.LinkedList;
import java.util.List;

public class MergeTwoSortedLists {

    //https://leetcode.com/problems/merge-two-sorted-lists/

    public static void main(String[] args) {

        ListNode list1 = null;
        list1 = insertEnd(list1, 1);
        list1 = insertEnd(list1, 2);
        list1 = insertEnd(list1, 4);

        printListNode(list1);

        ListNode list2 = null;
        list2 = insertEnd(list2, 1);
        list2 = insertEnd(list2, 3);
        list2 = insertEnd(list2, 4);

        printListNode(list2);

        printListNode(mergeTwoLists(list1, list2));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode newNode(int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = null;
        return node;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode result = null;

        while (list1 != null || list2 != null) {
            if (list1 == null && list2 != null) {
                result = insertEnd(result, list2.val);
                list2 = list2.next;
            } else if (list1 != null && list2 == null) {
                result = insertEnd(result, list1.val);
                list1 = list1.next;
            } else {
                result = insertEnd(result, Math.min(list1.val, list2.val));
                if (list1.val <= list2.val) {
                    list1 = list1.next;
                } else {
                    list2 = list2.next;
                }
            }
        }

        return result;
    }

    public static ListNode insertEnd(ListNode result, int val) {
        if (result == null) {
            return newNode(val);
        } else {
            result.next = insertEnd(result.next, val);
        }

        return result;
    }

    public static void printListNode(ListNode listNode) {
        System.out.print("ListNode : [");
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println("]");
    }
}
