import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 */

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode c1 = new TreeNode(2);
        TreeNode c2 = new TreeNode(3);
        TreeNode c3 = new TreeNode(4);
        TreeNode c4 = new TreeNode(5);
        TreeNode c5 = new TreeNode(6);
        TreeNode c6 = new TreeNode(7);
        root.left = c1;
        root.right = c2;
        c1.left = c3;
        c2.right = c5;
        c2.left = c4;
        c4.right = c6;
        System.out.println(findBottomLeftValue(root));
    }

    private static int findBottomLeftValue(TreeNode root) {
        if (root.left == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currNode = root;
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode.right != null) {
                queue.offer(currNode.right);
            }
            if (currNode.left != null) {
                queue.offer(currNode.left);
            }
        }
        return currNode.val;
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
