import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashmap/description/
 */
public class DesignHashMap {

    private int[] mMap;

    /**
     * Initialize your data structure here.
     */
    private DesignHashMap() {
        mMap = new int[1000000];
        Arrays.fill(mMap, -1);
    }

    public static void main(String[] args) {
        DesignHashMap designHashMap = new DesignHashMap();
        designHashMap.put(1, 2);
        designHashMap.put(2, 3);
        System.out.println(designHashMap.get(2));
        designHashMap.put(2, 4);
        System.out.println(designHashMap.get(2));
        designHashMap.remove(2);
        System.out.println(designHashMap.get(2));
        System.out.println(designHashMap.get(4));
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        mMap[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return mMap[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        mMap[key] = -1;
    }

}
