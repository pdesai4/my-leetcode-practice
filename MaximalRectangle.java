import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/description/
 */

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrixIn = new char[4][5];
        matrixIn[0][0] = '1';
        matrixIn[0][1] = '0';
        matrixIn[0][2] = '1';
        matrixIn[0][3] = '0';
        matrixIn[0][4] = '0';
        matrixIn[1][0] = '1';
        matrixIn[1][1] = '0';
        matrixIn[1][2] = '1';
        matrixIn[1][3] = '1';
        matrixIn[1][4] = '1';
        matrixIn[2][0] = '1';
        matrixIn[2][1] = '1';
        matrixIn[2][2] = '1';
        matrixIn[2][3] = '1';
        matrixIn[2][4] = '1';
        matrixIn[3][0] = '1';
        matrixIn[3][1] = '0';
        matrixIn[3][2] = '0';
        matrixIn[3][3] = '1';
        matrixIn[3][4] = '0';
        MaximalRectangle mR = new MaximalRectangle();
        System.out.println(mR.maximalRectangle(matrixIn));
    }

    private int maximalRectangle(char[][] matrixIn) {
        int area, maxArea = 0;
        if (matrixIn == null || matrixIn.length == 0) {
            return 0;
        }
        for (int i = 0; i < matrixIn.length; i++) {
            for (int j = 0; j < matrixIn[i].length; j++) {
                matrixIn[i][j] = (char) Character.getNumericValue(matrixIn[i][j]);
            }
        }
        char[] currArray = new char[matrixIn[0].length];
        for (int i = 0; i < matrixIn.length; i++) {
            if (i == 0) {
                currArray = matrixIn[0];
            } else {
                for (int j = 0; j < matrixIn[0].length; j++) {
                    if (matrixIn[i][j] == 0) {
                        currArray[j] = 0;
                    } else {
                        currArray[j] = (char) (currArray[j] + matrixIn[i][j]);
                    }
                }
            }

            area = getMaxArea(currArray);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }

    private int getMaxArea(char[] currArray) {
        if (currArray == null || currArray.length == 0) {
            return 0;
        }
        int area, maxArea = 0, i;
        Stack<Integer> stack = new Stack<>();
        for (i = 0; i < currArray.length; ) {
            if (stack.empty() || (currArray[stack.peek()]) <= (currArray[i])) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.empty()) {
                    area = (currArray[top]) * i;
                } else {
                    area = (currArray[top]) * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.empty()) {
            int top = stack.pop();
            if (stack.empty()) {
                area = (currArray[top]) * i;
            } else {
                area = (currArray[top]) * (i - stack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
