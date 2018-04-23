import java.util.Scanner;

/**
 * https://www.programcreek.com/2014/08/leetcode-shortest-word-distance-java/
 */

public class ShortestWordDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < str.length; i++) {
            str[i] = scanner.next();
        }
        String word1 = scanner.next();
        String word2 = scanner.next();
        int ans = calculateShortestDistance(str, word1, word2);
        System.out.println(ans);
    }

    private static int calculateShortestDistance(String[] str, String word1, String word2) {
        int m = -1, n = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(word1)) {
                m = i;
                if (n != -1) {
                    min = Math.min(min, m - n);
                }

            } else {
                n = i;
                if (m != -1) {
                    min = Math.min(min, n - m);
                }
            }
        }
        return min;
    }
}
