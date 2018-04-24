import java.util.Scanner;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */

class UniquePaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(m, n));
    }

    private int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            matrix[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }
}