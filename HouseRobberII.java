/**
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(houseRobberII.rob(nums));
    }

    private int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int prev = 0, curr = 0, i = 0;

        for (i = lo; i <= hi; i++) {
            int temp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = temp;
        }
        return curr;
    }
}
