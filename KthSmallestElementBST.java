import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementBST {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
        System.out.println(kthSmallestElementBST.kthSmallest(n1, 5));
    }

    private int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        inorderList(root, list);
        if (k > list.size()) {
            return 0;
        }
        return list.get(k - 1);
    }

    private void inorderList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderList(root.left, list);
        list.add(root.val);
        inorderList(root.right, list);
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
