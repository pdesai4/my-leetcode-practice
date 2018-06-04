import java.util.Scanner;

/**
 * https://leetcode.com/problems/integer-replacement/description/
 */

public class IntegerReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(integerReplacement.integerReplacement(n));
    }

    private int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n = n >>> 1;
            } else {
                if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                    n = n - 1;
                } else {
                    n = n + 1;
                }
            }
            count++;
        }
        return count;
    }
}
