import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 */

public class FractionToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.close();

        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.ftoD(n, d));
    }

    private String ftoD(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        // Taking care of sign
        if (numerator < 0 ^ denominator < 0) {
            stringBuilder.append("-");
        }
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);

        stringBuilder.append(numeratorL / denominatorL);
        numeratorL = numeratorL % denominatorL;

        // check if completely divided
        if (numeratorL == 0) {
            return stringBuilder.toString();
        }

        stringBuilder.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(numeratorL, stringBuilder.length());

        while (numeratorL != 0) {
            numeratorL = numeratorL * 10;
            stringBuilder.append(numeratorL / denominatorL);
            numeratorL = numeratorL % denominatorL;

            if (map.containsKey(numeratorL)) {
                stringBuilder.insert(map.get(numeratorL), "(");
                stringBuilder.append(")");
                break;
            } else {
                map.put(numeratorL, stringBuilder.length());
            }
        }

        return stringBuilder.toString();
    }
}