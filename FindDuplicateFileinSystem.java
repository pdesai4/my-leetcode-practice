import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/description/
 */

public class FindDuplicateFileinSystem {
    public static void main(String[] args) {
        String[] input = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        FindDuplicateFileinSystem findDuplicateFileinSystem = new FindDuplicateFileinSystem();
        List<List<String>> result = findDuplicateFileinSystem.findDuplicate(input);
        System.out.println(result);
    }

    private List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] subString = s.split("[()\\s][\\s]*");
            int i = 2;
            if (subString.length > 1) {
                while (i < subString.length) {
                    String filePath = subString[0] + "/" + subString[i - 1];
                    if (map.containsKey(subString[i])) {
                        map.get(subString[i]).add(filePath);
                    } else {
                        List<String> list = new ArrayList<>();
                        list.add(filePath);
                        map.put(subString[i], list);
                    }
                    i += 2;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String k : map.keySet()) {
            if (map.get(k).size() > 1) {
                result.add(map.get(k));
            }
        }

        return result;
    }
}