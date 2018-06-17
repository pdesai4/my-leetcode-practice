/**
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersionNumbers {
    public static void main(String[] args) {
        String v1 = "1.0.1";
        String v2 = "1";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion(v1, v2));
    }

    private int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("[.]");
        String[] version2Array = version2.split("[.]");

        int maxLength = Math.max(version1Array.length, version2Array.length);

        for (int i = 0; i < maxLength; i++) {
            int v1 = i < version1Array.length ? Integer.parseInt(version1Array[i]) : 0;
            int v2 = i < version2Array.length ? Integer.parseInt(version2Array[i]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}
