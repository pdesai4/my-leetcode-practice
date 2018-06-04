import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * https://leetcode.com/problems/shuffle-an-array/description/
 */

public class ShuffleAnArray {
    private int[] mOriginalArray;
    private int[] mCopyArray;

    private ShuffleAnArray(int[] nums) {
        mOriginalArray = nums;
        mCopyArray = new int[nums.length];
        System.arraycopy(nums, 0, mCopyArray, 0, nums.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(arr);
        System.out.println("Shuffled Array: " + Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println("Reset Array: " + Arrays.toString(shuffleAnArray.reset()));
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    private int[] reset() {
        return mOriginalArray;
    }

    /**
     * Returns a random shuffling of the array.
     */
    private int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < mCopyArray.length; i++) {
            int randomIndex = random.nextInt((mCopyArray.length - 1) + 1);
            mCopyArray = swap(mCopyArray, i, randomIndex);
        }
        return mCopyArray;
    }

    private int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }
}
