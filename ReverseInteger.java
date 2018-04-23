import java.util.Scanner;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(n));
    }

    private int reverse(int x) {
        int sign = 1;
        long lx = x;
        if (lx < 0) {
            sign = -1;
            lx = lx * -1;
        }
        char[] c = Long.toString(lx).toCharArray();
        System.out.println(c);
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        System.out.println(c);
        long lAns = Long.parseLong(new String(c));
        int ans;
        if (sign == -1) {
            lAns = lAns * sign;
        }
        if (lAns > Integer.MAX_VALUE || lAns < Integer.MIN_VALUE) {
            ans = 0;
        } else {
            ans = (int) lAns;
        }
        return ans;

    }
}
