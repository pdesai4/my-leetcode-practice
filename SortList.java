import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sort-list/description/
 */
public class SortList {
    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        printList(sortList.sortList(l1));
    }

    private static void printList(ListNode listNode) {
        ListNode c = listNode;
        while (c != null) {
            System.out.println(c.val);
            c = c.next;
        }
    }

    private ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        TreeMap<Integer, List<ListNode>> treeMap = new TreeMap<>();
        ListNode currNode = head;
        while (currNode != null) {
            if (treeMap.containsKey(currNode.val)) {
                treeMap.get(currNode.val).add(currNode);

            } else {
                List<ListNode> listNodes = new ArrayList<>();
                listNodes.add(currNode);
                treeMap.put(currNode.val, listNodes);
            }
            currNode = currNode.next;
        }
        ListNode result = treeMap.firstEntry().getValue().get(0);
        currNode = result;
        treeMap.firstEntry().getValue().remove(0);
        for (Integer key : treeMap.keySet()) {
            for (ListNode listNode : treeMap.get(key)) {
                listNode.next = null;
                currNode.next = listNode;
                currNode = currNode.next;
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
