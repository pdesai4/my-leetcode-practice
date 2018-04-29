import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 */

public class LRUCache {
    private int mCapacity;
    private Map<Integer, Integer> mMap;
    private LinkedList<Integer> mList;

    private LRUCache(int capacity) {
        mCapacity = capacity;
        mMap = new HashMap<>();
        mList = new LinkedList<>();
    }

    public static void main(String[] args) {
        // ["LRUCache","put","put","get","put","get","put","get","get","get"]
        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        List<Integer> result = new ArrayList<>();
        LRUCache lruCache = new LRUCache(2);
        result.add(null);
        lruCache.put(1, 1);
        result.add(null);
        lruCache.put(2, 2);
        result.add(null);
        int n1 = lruCache.get(1);
        result.add(n1);
        lruCache.put(3, 3);
        result.add(null);
        int n2 = lruCache.get(2);
        result.add(n2);
        lruCache.put(4, 4);
        result.add(null);
        int n3 = lruCache.get(1);
        result.add(n3);
        int n4 = lruCache.get(3);
        result.add(n4);
        int n5 = lruCache.get(4);
        result.add(n5);
        System.out.println(result);
    }

    private int get(int key) {
        if (mMap.containsKey(key)) {
            updateAccess(key);
            return mMap.get(key);
        }
        return -1;
    }

    private void updateAccess(int key) {
        if (mList.isEmpty()) {
            mList.add(key);
        } else {
            mList.removeFirstOccurrence(key);
            mList.addFirst(key);
        }
    }

    private void put(int key, int value) {
        if (mMap.containsKey(key)) {
            mMap.put(key, value);
            updateAccess(key);
            return;
        }
        if (mMap.size() < mCapacity) {
            mMap.put(key, value);
            updateAccess(key);

        } else {
            removeFromList();
            mMap.put(key, value);
            updateAccess(key);
        }
    }

    private void removeFromList() {
        int key = -1;
        if (!mList.isEmpty()) {
            key = mList.removeLast();
        }
        if (mMap.containsKey(key)) {
            mMap.remove(key);
        }
    }

}
