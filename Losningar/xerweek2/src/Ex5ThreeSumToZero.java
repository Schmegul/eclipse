import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.

    NOTE: Solution may max use two nested loops

 */
public class Ex5ThreeSumToZero {

    public static void main(String[] args) {
        new Ex5ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any
    }

    // NOTE: Solution may not contain nested loops
    int[] getThreeSum(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            int leftMost = arr[i];     // Select leftmost element to sum up against
            int left = i + 1;          // left is one to the right of leftMost
            int right = len - 1;       // right is last index
            while (left < right) {     // Shrink and compute sum for each
                int vl = arr[left];
                int vr = arr[right];
                //out.println(leftMost + " " + vl + " " + vr);
                if (leftMost + vl + vr == 0) {
                    //return new int[]{leftMost, vl, vr};
                    return new int[]{i, left, right};
                    //out.println("FOUND" + i + " " + left + " " + right);
                    // Continue search for all triplet combinations summing to zero.
                    //right--; // = right - 1;
                } else if (leftMost + vl + vr > 0) {
                    right--;   // Decrease sum by moving right to the left
                } else {
                    left++;    // Increase sum by moving left to the right
                }
            }
        }
        return new int[0];
    }
}
