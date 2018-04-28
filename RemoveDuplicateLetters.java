import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */

class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(input));
    }

    private String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ) {
            if (stack.empty()) {
                stack.push(c[i]);
                visited[c[i] - 'a'] = true;
                count[c[i] - 'a']--;
                i++;
                continue;
            }
            if (visited[c[i] - 'a']) {
                if (count[c[i] - 'a'] > 0) {
                    count[c[i] - 'a']--;
                }
                i++;
                continue;
            }
            if (stack.peek().compareTo(c[i]) > 0 && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            } else {
                stack.push(c[i]);
                visited[c[i] - 'a'] = true;
                count[c[i] - 'a']--;
                i++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}