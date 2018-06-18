import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        int[] nums = new int[]{1, 0, 1, 1};
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(nums, 1, 2));
    }

    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            Long floor = set.floor(num);
            Long ceil = set.ceiling(num);
            if ((null != floor && num - floor <= t) || (null != ceil && ceil - num <= t)) {
                return true;
            }
            set.add(num);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
