/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(maximumProductSubarray.maxProduct(nums));
    }

    private int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = nums[0];
        int max = result, min = result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);
            result = Math.max(result, max);
        }
        return result;
    }
}
