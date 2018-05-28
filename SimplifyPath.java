import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/simplify-path/description/
 */

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b/../../c//";
        SimplifyPath mSimplifyPath = new SimplifyPath();
        System.out.println(mSimplifyPath.simplifyPath(path));
    }

    private String simplifyPath(String path) {
        String[] strArr = path.split("[/]");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].equals("..") && !linkedList.isEmpty()) {
                linkedList.removeLast();
            } else if (!strArr[i].equals(".") && !strArr[i].equals("..") && !strArr[i].equals("")) {
                linkedList.add(strArr[i]);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        while (!linkedList.isEmpty() && linkedList.size() != 1) {
            stringBuilder.append(linkedList.removeFirst());
            stringBuilder.append("/");
        }
        if (!linkedList.isEmpty()) {
            stringBuilder.append(linkedList.removeFirst());
        }
        return stringBuilder.toString();
    }
}
