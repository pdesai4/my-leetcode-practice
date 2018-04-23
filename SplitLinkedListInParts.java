/**
 * https://leetcode.com/problems/split-linked-list-in-parts/description/
 */

class SplitLinkedListInParts {
    public static void main(String[] args) {
        SplitLinkedListInParts s = new SplitLinkedListInParts();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        ListNode[] result = s.splitListToParts(n1, 5);
        printL(result);
    }

    private static void printL(ListNode[] result) {
        for (ListNode l : result) {
            if (l == null) {
                System.out.println("null");
            } else {
                System.out.println(l.val);
            }
        }
    }

    private ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null || k < 1) {
            return result;
        }
        // Calculate the size of the list
        int size = 0;
        ListNode temp = root;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (size < k) {
            temp = root;
            for (int i = 0; i < result.length; i++) {
                if (temp != null) {
                    result[i] = temp;
                    temp = temp.next;
                    result[i].next = null;
                } else {
                    result[i] = null;
                }
            }

        } else {
            int numberOfMembers = size / k;
            int carry = size % k;
            temp = root;

            for (int i = 0; i < result.length; i++) {
                result[i] = temp;
                for (int j = 1; j < numberOfMembers; j++) {
                    temp = temp.next;
                }
                if (carry > 0) {
                    temp = temp.next;
                    carry--;
                }
                ListNode curr = temp;
                temp = temp.next;
                curr.next = null;
            }

        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
