/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 8, 1, 2};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums));
    }

    private int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (nums.length == 1 || left == right) return nums[0];

        int mid = (left + right) / 2;

        if (mid > left && nums[mid] < nums[mid - 1]) {
            return nums[mid];
        }
        if (mid < right && nums[mid] > nums[mid + 1]) {
            return nums[mid + 1];
        }
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        if (left < mid) {
            leftMin = binarySearch(nums, left, mid - 1);
        }
        if (mid < right) {
            rightMin = binarySearch(nums, mid + 1, right);
        }
        return Math.min(leftMin, rightMin);
    }
}
