import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 */
public class BinarySearchTreeIterator {

    private Stack<Integer> mStack;

    private BinarySearchTreeIterator(TreeNode root) {
        mStack = new Stack<>();
        traverseTree(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(13);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        BinarySearchTreeIterator binarySearchTreeIterator = new BinarySearchTreeIterator(root);
        while (binarySearchTreeIterator.hasNext()) {
            System.out.println(binarySearchTreeIterator.next());
        }
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseTree(root.right);
        mStack.push(root.val);
        traverseTree(root.left);
    }

    /**
     * @return whether we have a next smallest number
     */
    private boolean hasNext() {
        return !mStack.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return mStack.pop();
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
