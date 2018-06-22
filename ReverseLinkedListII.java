/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 */
public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode res = reverseLinkedListII.reverseBetween(listNode1, 2, 4);
        reverseLinkedListII.printList(res);
    }

    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n <= m) {
            return head;
        }
        ListNode mHead = head;
        if (m == 1) {
            return reverseList(mHead, n - m);
        }
        for (int i = 1; i < m - 1; i++) {
            mHead = mHead.next;
        }

        mHead.next = reverseList(mHead.next, n - m);
        return head;
    }

    private ListNode reverseList(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp = new ListNode(-1);
        ListNode curr = head;
        ListNode nextCurr = curr.next;
        while (n > 0) {
            curr.next = temp;
            temp = curr;
            curr = nextCurr;
            nextCurr = curr.next;
            n--;
        }
        curr.next = temp;
        head.next = nextCurr;
        return curr;
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
