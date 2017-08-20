package algs4;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

import java.util.Random;

public class BinarySearchRecursive {

    private static Random random = new Random();
    private static int binarySearch(int[] arr, int l, int r, int key) {
        if (r >= l) {
            int mid = (l + r) /2;
            if (arr[mid] == key) return mid;
            if (arr[mid] > key)  return binarySearch(arr, l, mid-1, key);
            if (arr[mid] < key)  return binarySearch(arr, mid+1, r, key);
        }
        return -1;
    }

    private static int getRandomInArray(int[] arr) {
        int index = random.nextInt(arr.length);
        return arr[index];
    }

    public static void main(String args[]) {
        int length = 100;
        int[] arr = new int[length];
        int r = length - 1;

        for (int i = 0; i < length; i++)
            arr[i] = random.nextInt();

        Arrays.sort(arr);
        int key = getRandomInArray(arr);
        StdOut.println("ARRAY:");
        for (int i = 0; i < length; i++)
            StdOut.print(arr[i] + " ");
        StdOut.println("\nKEY\n" + key);

        StdOut.println("\n" + binarySearch(arr, 0, r, key));
    }
}
