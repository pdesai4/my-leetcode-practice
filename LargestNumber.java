import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-number/description/
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] nums = new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println(largestNumber.largestNumber(nums));
    }

    private String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, new ArrayList<>());
        }

        for (int num : nums) {
            if (num < 10) {
                list.get(num).add(num);
            } else {
                int i = 0;
                int currNum = num;
                while (currNum != 0) {
                    i = currNum % 10;
                    currNum /= 10;
                }
                list.get(i).add(num);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).size() == 1) {
                stringBuilder.append(list.get(i).get(0));

            } else if (list.get(i).size() > 1) {
                list.get(i).sort((o1, o2) -> {
                    String o1String = o1.toString();
                    String o2String = o2.toString();
                    if ((o1String + o2String).compareTo(o2String + o1String) < 0) {
                        return 1;
                    }
                    return -1;
                });
                System.out.println(list.get(i));
                for (int n : list.get(i)) {
                    stringBuilder.append(n);
                }
            }
        }

        if (stringBuilder.indexOf("0") == 0) return "0";
        return stringBuilder.toString();
    }
}
