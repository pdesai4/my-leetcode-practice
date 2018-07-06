import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/buddy-strings/description/
 */
public class BuddyStrings {

    public static void main(String[] args) {
        String A = "aabac";
        String B = "aaabd";
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.buddyStrings(A, B));
    }

    private boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length() || A.length() == 0) {
            return false;
        }

        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();

        if (A.equals(B)) {
            // Look for duplicate char
            Set<Character> set = new HashSet<>();
            for (char anArrA : arrA) {
                if (set.contains(anArrA)) {
                    return true;
                } else {
                    set.add(anArrA);
                }
            }
        } else {
            // Look for two diff chars
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arrA.length; i++) {
                if (arrA[i] != arrB[i]) {
                    list.add(i);
                }
            }
            if (list.size() == 2 && arrA[list.get(0)] == arrB[list.get(1)] && arrA[list.get(1)] == arrB[list.get(0)]) {
                return true;
            }
        }
        return false;
    }
}
