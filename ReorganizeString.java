import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 */
public class ReorganizeString {

    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aaab"));
    }

    private String reorganizeString(String S) {
        if (S == null || S.length() < 1) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = S.toCharArray();
        int threshold = (charArray.length + 1) / 2;
        for (char c : charArray) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<HeapData> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count) {
                return o1.character - o2.character;
            }
            return o2.count - o1.count;
        });

        for (char c : map.keySet()) {
            if (map.get(c) > threshold) {
                return "";
            }
            priorityQueue.add(new HeapData(c, map.get(c)));
        }

        return formString(priorityQueue);
    }

    private String formString(PriorityQueue<HeapData> priorityQueue) {
        StringBuilder stringBuilder = new StringBuilder();

        while (priorityQueue.size() >= 2) {
            HeapData o1 = priorityQueue.poll();
            HeapData o2 = priorityQueue.poll();
            stringBuilder.append(o1.character);
            stringBuilder.append(o2.character);
            o1.count--;
            o2.count--;
            if (o1.count > 0) {
                priorityQueue.add(o1);
            }
            if (o2.count > 0) {
                priorityQueue.add(o2);
            }
        }
        while (priorityQueue.size() > 0) {
            stringBuilder.append(priorityQueue.poll().character);
        }

        return stringBuilder.toString();
    }

    private class HeapData {
        private char character;
        private int count;

        HeapData(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}

