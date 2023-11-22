package Losningar.xerweek3.src;

import java.util.Arrays;

import static java.lang.System.out;

/*
 * Even more array methods, possibly even harder ...
 */
public class Ex5MedianKthSmallest {

    public static void main(String[] args) {
        new Ex5MedianKthSmallest().program();
    }

    void program() {
        int[] arr1 = {9, 3, 0, 1, 3, -2};

        out.println(!isSorted(arr1));  // Is sorted increasing? No not yet!

        bSort(arr1);     // BubbleSort in increasing order original order lost!
        //iSort(arr1);    // Or like this

        out.println(Arrays.toString(arr1).equals("[-2, 0, 1, 3, 3, 9]"));

        out.println(isSorted(arr1));  // Is sorted increasing? Yes!

        int[] arr2 = {5, 4, 2, 1, 7, 0, -1, -4, 12};
        int[] arr3 = {2, 3, 0, 1};
        out.println(median(arr2) == 2);    // Calculate median of elements
        out.println(median(arr3) == 1.5);

        int[] arr4 = {2, 3, 0, 1, 5, 4};
        int[] arr5 = {5, 4, 2, 2, 1, 7, 4, 0, -1, -4, 0, 0, 12};
        out.println(kSmallest(arr4, 2) == 1);   // Second smallest is 1
        out.println(kSmallest(arr5, 5) == 2);   // 5th smallest is 2

    }

    // ---------- Write methods here --------------

    // Increasing
    boolean isSorted(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    double median(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        iSort(arr);      // Use sorting!
        if (arr.length % 2 == 0) {
            return (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }

    int kSmallest(int[] arr, int k) {
        iSort(arr);
        int i = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i + 1] > arr[i]) {
                count++;
            }
            if (count == k) {
                break;
            }
            i++;
        }
        return arr[i];
    }

    // Bubble sort
    void bSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble sort again (original array NOT lost)
    int[] bSort2(int[] arr) {
        int[] cpy = copy(arr);
        for (int i = 0; i < cpy.length - 1; i++) {
            for (int j = 0; j < cpy.length - i - 1; j++) {
                if (cpy[j] > cpy[j + 1]) {
                    int temp = cpy[j];
                    cpy[j] = cpy[j + 1];
                    cpy[j + 1] = temp;
                }
            }
        }
        return cpy;   // return the copy
    }

    // Insertion sort
    void iSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }

    int[] copy(int[] arr) {
        int[] cpy = new int[arr.length];         // Make a copy
        for (int i = 0; i < arr.length; i++) {
            cpy[i] = arr[i];
        }
        return cpy;
    }

}
