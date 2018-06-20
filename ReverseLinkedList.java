/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode res = reverseLinkedList.reverseList(listNode1);
        reverseLinkedList.printList(res);
    }

    private void printList(ListNode res) {
        if (res == null) {
            return;
        }
        ListNode temp = res;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr, nextCurr, temp;
        ListNode tempHead = new ListNode(-1);
        temp = tempHead;
        curr = head;
        nextCurr = curr.next;
        while (curr.next != null) {
            curr.next = temp;
            temp = curr;
            curr = nextCurr;
            nextCurr = curr.next;
        }
        curr.next = temp;
        head.next = null;
        return curr;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
