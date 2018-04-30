import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/description/
 */

public class LFUCache {
    private int mCapacity;
    private Map<Integer, Node> mMap;
    private Map<Integer, LinkedList<Node>> mFreqMap;

    private LFUCache(int capacity) {
        mCapacity = capacity;
        mMap = new HashMap<>();
        mFreqMap = new HashMap<>();
    }

    public static void main(String[] args) {
        // ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        List<Integer> result = new ArrayList<>();
        LFUCache lfuCache = new LFUCache(2);
        result.add(null);
        lfuCache.put(1, 1);
        result.add(null);
        lfuCache.put(2, 2);
        result.add(null);
        int n1 = lfuCache.get(1);
        result.add(n1);
        lfuCache.put(3, 3);
        result.add(null);
        int n2 = lfuCache.get(2);
        result.add(n2);
        int n3 = lfuCache.get(3);
        result.add(n3);
        lfuCache.put(4, 4);
        result.add(null);
        int n4 = lfuCache.get(1);
        result.add(n4);
        int n5 = lfuCache.get(3);
        result.add(n5);
        int n6 = lfuCache.get(4);
        result.add(n6);
        System.out.println(result);
    }

    private int get(int key) {
        if (mMap.containsKey(key)) {
            int currFreq = mMap.get(key).freq;
            mFreqMap.get(currFreq).removeFirstOccurrence(mMap.get(key));
            currFreq++;
            if (mFreqMap.containsKey(currFreq)) {
                mFreqMap.get(currFreq).addFirst(mMap.get(key));
            } else {
                LinkedList<Node> l = new LinkedList<>();
                l.addFirst(mMap.get(key));
                mFreqMap.put(currFreq, l);
            }
            mMap.get(key).freq = currFreq;
            return mMap.get(key).value;
        }
        return -1;
    }


    private void put(int key, int value) {
        if (mCapacity == 0) {
            return;
        }
        if (mMap.containsKey(key)) {
            int currFreq = mMap.get(key).freq;
            mFreqMap.get(currFreq).removeFirstOccurrence(mMap.get(key));
            currFreq++;
            if (mFreqMap.containsKey(currFreq)) {
                mFreqMap.get(currFreq).addFirst(mMap.get(key));
            } else {
                LinkedList<Node> l = new LinkedList<>();
                l.addFirst(mMap.get(key));
                mFreqMap.put(currFreq, l);
            }
            mMap.get(key).value = value;
            mMap.get(key).freq = currFreq;
            return;
        }
        if (mMap.size() < mCapacity) {
            Node node = new Node(key, value, 1);
            if (mFreqMap.containsKey(node.freq)) {
                mFreqMap.get(node.freq).addFirst(node);
            } else {
                LinkedList<Node> l = new LinkedList<>();
                l.addFirst(node);
                mFreqMap.put(node.freq, l);
            }
            mMap.put(key, node);

        } else {
            Node removedNode;
            for (Integer i : mFreqMap.keySet()) {
                if (mFreqMap.get(i) != null && !mFreqMap.get(i).isEmpty()) {
                    removedNode = mFreqMap.get(i).removeLast();
                    mMap.remove(removedNode.key);
                    break;
                }
            }
            put(key, value);
        }
    }

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
}
