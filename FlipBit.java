import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/flipping-bits/problem
 */

public class FlipBit {

    private static long flippingBits(long N) {
        long max = (long) Math.pow(2, 32) - 1;
        return max - N;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++) {
            long N = in.nextLong();
            long result = flippingBits(N);
            System.out.println(result);
        }
        in.close();
    }
}