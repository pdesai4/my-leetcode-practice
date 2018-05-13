import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 */

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("ab", "aa"));
    }

    private boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(sArr[i])) {
                if (map.containsValue(tArr[i])) {
                    return false;
                }
                map.put(sArr[i], tArr[i]);
            } else {
                if (map.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
