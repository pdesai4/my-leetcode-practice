import java.util.Scanner;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 */

public class ReverseWordsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords(input));
    }

    private String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] strArray = s.split("[\\s]");
        if (strArray.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = strArray.length - 1; i >= 0; i--) {
            strArray[i] = strArray[i].replace(" ", "");
            strArray[i] = strArray[i].trim();
            if (strArray[i].equals("")) {
                continue;
            }
            sb.append(strArray[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        if (sb.lastIndexOf(" ") == sb.length() - 1) {
            return sb.toString().trim();
        }
        return sb.toString();
    }
}
