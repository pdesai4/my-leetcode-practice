import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 */

public class BinaryTreeZigZagTraversal {

    public static void main(String[] args) {
        BinaryTreeZigZagTraversal binaryTreeZigZagTraversal = new BinaryTreeZigZagTraversal();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(binaryTreeZigZagTraversal.zigzagLevelOrder(n1));
    }

    private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<TreeNode> even = new Stack<>();
        Stack<TreeNode> odd = new Stack<>();
        int currHeight = 0;
        even.push(root);
        TreeNode currNode;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        map.put(currHeight, list);

        while (!even.empty() || !odd.empty()) {
            List<Integer> list1 = new ArrayList<>();
            if (currHeight % 2 == 0) {
                while (!even.empty()) {
                    currNode = even.pop();
                    if (currNode.right != null) {
                        odd.push(currNode.right);
                        list1.add(currNode.right.val);
                    }
                    if (currNode.left != null) {
                        odd.push(currNode.left);
                        list1.add(currNode.left.val);
                    }
                }

            } else {
                while (!odd.empty()) {
                    currNode = odd.pop();
                    if (currNode.left != null) {
                        even.push(currNode.left);
                        list1.add(currNode.left.val);
                    }
                    if (currNode.right != null) {
                        even.push(currNode.right);
                        list1.add(currNode.right.val);
                    }
                }

            }
            currHeight++;
            if (!list1.isEmpty()) {
                map.put(currHeight, list1);
            }
        }
        return new ArrayList<>(map.values());
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
