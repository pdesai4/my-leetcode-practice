import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

class AllAnagramsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String p = scanner.next();
        scanner.close();
        AllAnagramsInString allAnagramsInString = new AllAnagramsInString();
        List<Integer> res = allAnagramsInString.findAnagrams(s, p);
        System.out.println(res);
    }

    private List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] pCount = new int[26];
        int pLength = p.length();
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - pLength + 1; i++) {
            int[] sCount = new int[26];
            int temp = pLength;
            int j = i;
            while (temp > 0) {
                sCount[c[j] - 'a']++;
                j++;
                temp--;
            }
            if (Arrays.equals(sCount, pCount)) {
                list.add(i);
            }
        }
        return list;
    }
}
