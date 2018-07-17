/**
 * https://leetcode.com/problems/reorder-list/description/
 */
public class ReorderList {

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reorderList.reorderList(n1);
        printList(n1);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }
        System.out.println("null");
    }

    private void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode temp = head;
        ListNode tempNext = head.next;
        while (tempNext != null && tempNext.next != null) {
            ListNode last = getLastNode(temp);
            temp.next = last;
            last.next = tempNext;
            temp = tempNext;
            tempNext = temp.next;
        }
    }

    private ListNode getLastNode(ListNode head) {
        ListNode headNext = head.next;
        while (headNext.next != null) {
            headNext = headNext.next;
            head = head.next;
        }
        head.next = null;
        return headNext;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
