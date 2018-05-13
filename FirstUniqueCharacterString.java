import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class FirstUniqueCharacterString {
    public static void main(String[] args) {
        FirstUniqueCharacterString firstUniqueCharacterString = new FirstUniqueCharacterString();
        System.out.println(firstUniqueCharacterString.firstUniqChar("loeleetcode"));
    }

    private int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        Iterator iterable = map.keySet().iterator();
        char res = '\0';
        while (iterable.hasNext()) {
            char c = (char) iterable.next();
            if (map.get(c) == 1) {
                res = c;
                break;
            }
        }
        if (res != '\0') {
            return s.indexOf(res);
        }
        return -1;
    }
}
