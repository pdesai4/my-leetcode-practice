import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat not dog"));
    }

    private boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] strArr = str.split("[\\s]");
        Queue<Character> queue = new LinkedList<>();
        char[] charArray = pattern.toCharArray();
        if (charArray.length != strArr.length) {
            return false;
        }
        for (char c : charArray) {
            if (!queue.contains(c)) {
                queue.add(c);
            }
        }
        Map<String, Character> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strArr) {
            if (!map.containsKey(s)) {
                map.put(s, queue.poll());
            }
            stringBuilder.append(map.get(s));
        }
        return pattern.equals(stringBuilder.toString());
    }
}
