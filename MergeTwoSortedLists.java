/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode n1 = new ListNode(2);
        ListNode m1 = new ListNode(-9);
        ListNode m2 = new ListNode(-6);
        ListNode m3 = new ListNode(-4);
        ListNode m4 = new ListNode(-3);
        ListNode m5 = new ListNode(-2);
        ListNode m6 = new ListNode(2);
        ListNode m7 = new ListNode(3);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;
        m6.next = m7;
        ListNode res = mergeTwoSortedLists.mergeTwoLists(n1, m1);
        printList(res);
    }

    private static void printList(ListNode res) {
        ListNode temp = res;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode currNode = head;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    currNode.next = l1;
                    l1 = l1.next;

                } else {
                    currNode.next = l2;
                    l2 = l2.next;
                }

            } else if (l1 != null) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
