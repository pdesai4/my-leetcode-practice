import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsDuplicateII.containsNearbyDuplicate(nums, 2));
    }

    private boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
