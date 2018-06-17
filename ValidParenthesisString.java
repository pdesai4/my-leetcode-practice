/**
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 */
public class ValidParenthesisString {
    public static void main(String[] args) {
        ValidParenthesisString validParenthesisString = new ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    private boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] charArray = s.toCharArray();
        int counter = 0;
        for (char c : charArray) {
            if (c == '(' || c == '*') {
                counter++;
            } else {
                counter--;
            }
            if (counter < 0) {
                return false;
            }
        }
        counter = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ')' || charArray[i] == '*') {
                counter++;
            } else {
                counter--;
            }
            if (counter < 0) {
                return false;
            }
        }
        return true;
    }
}
