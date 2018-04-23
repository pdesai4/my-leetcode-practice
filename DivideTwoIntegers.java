import java.util.Scanner;

/**
 * https://leetcode.com/problems/divide-two-integers/description/
 */
class DivideTwoIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();
        scanner.close();

        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(dividend, divisor));
    }

    private int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        if (lDivisor == 0) return Integer.MAX_VALUE;
        if ((lDividend == 0) || (lDividend < lDivisor)) return 0;
        long lAns;

        if (lDivisor == 1) {
            lAns = lDividend;
        } else {
            lAns = lDivide(lDividend, lDivisor);
        }

        int ans;

        if (lAns > Integer.MAX_VALUE) {
            ans = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            ans = (int) (sign * lAns);
        }
        return ans;
    }

    private long lDivide(long lDividend, long lDivisor) {
        long quotient = 0;
        while (lDividend >= lDivisor) {
            lDividend -= lDivisor;
            quotient++;
        }
        return quotient;
    }
}