import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        System.out.println(jewelsAndStones.numJewelsInStones("z", "aAAbbbb"));
    }

    private int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
