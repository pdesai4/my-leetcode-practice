import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes minimumDist = new MinimumDistanceBetweenBSTNodes();
        TreeNode treeNode1 = new TreeNode(71);
        TreeNode treeNode2 = new TreeNode(62);
        TreeNode treeNode3 = new TreeNode(84);
        TreeNode treeNode4 = new TreeNode(14);
        TreeNode treeNode5 = new TreeNode(88);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(minimumDist.minDiffInBST(treeNode1));
    }

    private int minDiffInBST(TreeNode root) {
        int minDistance = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        getValues(list, root);
        for (int i = 0; i < list.size() - 1; i++) {
            minDistance = Math.min(minDistance, list.get(i + 1) - list.get(i));
        }
        return minDistance;
    }

    private void getValues(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        getValues(list, root.left);
        list.add(root.val);
        getValues(list, root.right);
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
