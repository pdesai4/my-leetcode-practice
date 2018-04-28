import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 */

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(s));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Integer[] arr = new Integer[26];
            for (char c : s.toCharArray()) {
                if (null == arr[c - 'a']) {
                    arr[c - 'a'] = 1;
                } else {
                    arr[c - 'a']++;
                }
            }
            if (!map.containsKey(Arrays.toString(arr))) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(Arrays.toString(arr), list);
            } else {
                map.get(Arrays.toString(arr)).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}
