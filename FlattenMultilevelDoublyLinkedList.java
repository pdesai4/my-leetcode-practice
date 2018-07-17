/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 */
public class FlattenMultilevelDoublyLinkedList {

    public static void main(String[] args) {
        FlattenMultilevelDoublyLinkedList fMDL = new FlattenMultilevelDoublyLinkedList();
        Node n1 = new Node(1, null, null, null);
        Node n2 = new Node(2, n1, null, null);
        Node n3 = new Node(3, n2, null, null);
        Node n7 = new Node(7, null, null, null);
        Node n8 = new Node(8, n7, null, null);
        Node n9 = new Node(9, n8, null, null);
        Node n10 = new Node(10, n9, null, null);
        Node n11 = new Node(11, null, null, null);
        Node n12 = new Node(12, n11, null, null);
        n1.next = n2;
        n2.next = n3;
        n3.child = n7;
        n7.next = n8;
        n8.next = n9;
        n8.child = n11;
        n9.next = n10;
        n11.next = n12;
        printList(fMDL.flattenRecurr(n1));
    }

    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + "-");
            node = node.next;
        }
        System.out.println("null");
    }

    private Node flattenRecurr(Node head) {
        if (head == null) {
            return null;
        }
        Node hasChild = head;
        while (hasChild != null && hasChild.child == null) {
            hasChild = hasChild.next;
        }
        if (hasChild == null) return head;
        Node temp = hasChild.next;
        hasChild.next = flattenRecurr(hasChild.child);
        hasChild.child = null;
        if (hasChild.next != null) {
            hasChild.next.prev = hasChild;
        }

        while (hasChild.next != null) {
            hasChild = hasChild.next;
        }
        if (temp != null) {
            temp.prev = hasChild;
        }
        hasChild.next = flattenRecurr(temp);
        return head;
    }

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

}
