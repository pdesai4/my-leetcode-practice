import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 */

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(arr));
    }

    private int largestRectangleArea(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int area, maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        for (i = 0; i < arr.length; ) {
            if (stack.empty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.empty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!stack.empty()) {
            int top = stack.pop();
            if (stack.empty()) {
                area = arr[top] * i;
            } else {
                area = arr[top] * (i - stack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
