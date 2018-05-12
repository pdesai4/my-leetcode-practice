/**
 * https://leetcode.com/problems/non-decreasing-array/description/
 */

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 2, 3};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility(arr));
    }

    private boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean found = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (found) {
                    return false;
                }
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                }
                found = true;
            }
        }
        return true;
    }
}
