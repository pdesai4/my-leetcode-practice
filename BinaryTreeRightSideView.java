import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        root.left = n1;
        root.right = n2;
        n1.right = n3;
        n2.left = n5;
        n2.right = n4;
        System.out.println(binaryTreeRightSideView.rightSideView(root));
    }

    private List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> list = new LinkedList<>();
        result.add(root.val);
        if (root.left != null) list.add(root.left);
        if (root.right != null) list.add(root.right);

        while (!list.isEmpty()) {
            int index = list.size();
            result.add(list.get(index - 1).val);
            while (index > 0) {
                TreeNode node = list.removeFirst();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                index--;
            }
        }
        return result;
    }

    private void getRightChild(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        if (root.right != null) getRightChild(list, root.right);
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
