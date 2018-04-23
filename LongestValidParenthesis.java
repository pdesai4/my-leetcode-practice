import java.util.Scanner;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */

public class LongestValidParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(checkParenthesis(scanner.nextLine()));
        scanner.close();
    }

    private static int checkParenthesis(String s) {
        if (s == null) {
            return 0;
        }
        int ans = 0;
        char[] c = s.toCharArray();
        int left = 0, right = 0;
        for (char aC : c) {
            if (aC == ')') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return ans;
    }
}
