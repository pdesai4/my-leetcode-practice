/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = maximumBinaryTree.constructMaximumBinaryTree(nums);
        printTree(root);
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r) return new TreeNode(nums[l]);
        if (l > r) {
            return null;
        }
        int index = findMax(nums, l, r);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, l, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, r);
        return root;
    }

    private int findMax(int[] nums, int l, int r) {
        if (l == r) return l;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
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
