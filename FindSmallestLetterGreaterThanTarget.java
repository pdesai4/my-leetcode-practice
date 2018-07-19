/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget fSLGTT = new FindSmallestLetterGreaterThanTarget();
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'j';
        char res = fSLGTT.nextGreatestLetter(letters, target);
        System.out.println(res);
    }

    private char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0 || target == '\0') {
            return '\0';
        }
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }
}
