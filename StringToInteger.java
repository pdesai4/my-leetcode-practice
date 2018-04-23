import java.util.Scanner;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class StringToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi(input));
    }

    @SuppressWarnings("SpellCheckingInspection")
    private int myAtoi(String input) {
        if (input == null) {
            return 0;
        }

        input = input.trim();
        int index = 0, sign = 1;
        if (input.isEmpty()) {
            return 0;
        }

        if (input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        if (index >= input.length()) {
            return 0;
        }
        if (!Character.isDigit(input.charAt(index))) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        if (sign == -1) {
            sb.append("-");
        }
        for (char ch : input.substring(index).toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                break;
            }
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }

        }
    }
}
