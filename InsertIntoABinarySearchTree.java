/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 */
public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {
        InsertIntoABinarySearchTree insertIntoABinarySearchTree = new InsertIntoABinarySearchTree();
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.right = n4;
        n1.left = n3;
        TreeNode res = insertIntoABinarySearchTree.insertIntoBST(root, 5);
        printPreorder(res);
    }

    private static void printPreorder(TreeNode res) {
        if (res == null) return;
        if (res.left != null) printPreorder(res.left);
        System.out.println(res.val);
        if (res.right != null) printPreorder(res.right);
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        findPlace(root, val);
        return root;
    }

    private void findPlace(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left != null) {
                findPlace(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                findPlace(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
