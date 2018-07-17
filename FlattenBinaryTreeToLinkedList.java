/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        flattenBinaryTreeToLinkedList.flatten(n1);
    }

    private void flatten(TreeNode root) {
        flattenRecurr(root);
        printTree(root);
    }

    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    private TreeNode flattenRecurr(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode temp = root.right;
        root.right = flattenRecurr(root.left);
        root.left = null;
        TreeNode last = root;
        while (last.right != null) {
            last = last.right;
        }
        last.right = flattenRecurr(temp);
        return root;
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
