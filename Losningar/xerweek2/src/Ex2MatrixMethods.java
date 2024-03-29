package Losningar.xerweek2.src;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 *  See:
 *  ex2references
 *  ex5matrix
 */
public class Ex2MatrixMethods {

    public static void main(String[] args) {
        new Ex2MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        /* marked should be
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        /* matrix should be
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        //plot(matrix);  // If manual inspection
        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));

        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours
        out.println(sumNeighbours(matrix, 0, 0) == 11);
        out.println(sumNeighbours(matrix, 1, 1) == 40);
        out.println(sumNeighbours(matrix, 1, 0) == 23);
    }

    // -------- Write methods below this -----------------------

    int[] getNegatives(int[][] matrix) {
        int[] found = new int[countNegatives(matrix)];
        int k = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] < 0) {
                    found[k++] = matrix[r][c];
                }
            }
        }
        return found;
    }

    int countNegatives(int[][] m) {
        int count = 0;
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                if (m[r][c] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Mark all negatives with a 1 (others 0) in a new matrix
    // Return new matrix. Assume square matrix for parameter
    int[][] markNegatives(int[][] m) {
        int[][] marked = new int[m.length][m.length];  // New matrix, all elements 0 here
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m.length; c++) {
                if (m[r][c] < 0) {
                    marked[r][c] = 1;   // Mark it
                }
            }
        }
        return marked;
    }

    int[][] toMatrix(int[] arr) {
        int size = (int) round(sqrt(arr.length));
        int[][] matrix = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    int sumNeighbours(int[][] matrix, int row, int col) {
        int sum = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (!(row == r && col == c) && isValidLocation(matrix.length, r, c)) {
                    sum = sum + matrix[r][c];
                }
            }
        }
        return sum;
    }

    boolean isValidLocation(int size, int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size;
    }


    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }


}
