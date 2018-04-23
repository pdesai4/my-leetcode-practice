/**
 * https://leetcode.com/problems/rotate-list/description/
 */

class RotateList {

    public static void main(String[] args) {
        RotateList r = new RotateList();
        // [17,75,80,87,44,45,75,86,74,20]
        // k = 19
        ListNode n1 = new ListNode(17);
        ListNode n2 = new ListNode(75);
        ListNode n3 = new ListNode(80);
        ListNode n4 = new ListNode(87);
        ListNode n5 = new ListNode(44);
        ListNode n6 = new ListNode(45);
        ListNode n7 = new ListNode(75);
        ListNode n8 = new ListNode(86);
        ListNode n9 = new ListNode(74);
        ListNode n10 = new ListNode(20);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        r.printList(r.rotateRight(n1, 19));
    }

    private void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        temp.next = head;
        int index = size - k % size;
        temp = head;
        while (index > 1) {
            temp = temp.next;
            index--;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}