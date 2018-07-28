/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = new int[]{1, 3};
        int target = 0;
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return searchRecurr(nums, 0, nums.length - 1, target);
    }

    private int searchRecurr(int[] nums, int left, int right, int target) {
        if (left == right && nums[left] != target) {
            return -1;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }
}
