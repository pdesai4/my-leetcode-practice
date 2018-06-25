/**
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobberIII {

    public static void main(String[] args) {
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t6;
        System.out.println(houseRobberIII.rob(t1));
    }

    private int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int sumL = rob(root.left);
        int sumR = rob(root.right);

        int sumLL = (root.left != null) ? rob(root.left.left) : 0;
        int sumLR = (root.left != null) ? rob(root.left.right) : 0;
        int sumRL = (root.right != null) ? rob(root.right.left) : 0;
        int sumRR = (root.right != null) ? rob(root.right.right) : 0;

        return Math.max(root.val + sumLL + sumLR + sumRL + sumRR, sumL + sumR);
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
