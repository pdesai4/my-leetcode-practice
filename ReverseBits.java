import java.util.Scanner;

/**
 * https://leetcode.com/problems/reverse-bits/description/
 */

public class ReverseBits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(n));
    }

    private int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            n = rotateBit(n, i, 32 - i - 1);
        }
        return n;
    }

    private int rotateBit(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;
        if ((a ^ b) != 0) {
            n ^= (1 << i) | (1 << j);
        }
        return n;
    }
}