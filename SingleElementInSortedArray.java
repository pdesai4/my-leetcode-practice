/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 */
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] arrIn = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 8};
        SingleElementInSortedArray singleElementInSortedArray = new SingleElementInSortedArray();
        System.out.println(singleElementInSortedArray.singleNonDuplicate(arrIn));
    }

    private int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int n = mid % 2 == 0 ? mid + 1 : mid - 1;
            if (nums[mid] == nums[n]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
