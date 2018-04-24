import java.util.Scanner;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */

public class UniquePathswithObstacles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrixIn = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixIn[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        UniquePathswithObstacles uniquePathswithObstacles = new UniquePathswithObstacles();
        System.out.println(uniquePathswithObstacles.uniquePathsWithObstacles(matrixIn));
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            obstacleGrid[0][0] = 0;
        } else {
            obstacleGrid[0][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) {
                obstacleGrid[j][0] = 0;
            } else {
                obstacleGrid[j][0] = obstacleGrid[j - 1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
