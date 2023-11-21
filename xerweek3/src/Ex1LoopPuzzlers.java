package xerweek3.src;

import java.util.Arrays;

import static java.lang.System.out;

/*
 *  Some puzzlers
 *  General improvement of programming skills
 *
 *  See:
 *  - lectweek2/ex4algorithms/A3NestedLoops
 */
public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }


    void program() {
        // Write solution (for loops) directly here


        // Multiplication table
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++ ) {
                if (j*i < 10) {
                    out.print(" ");
                }
                out.print(j*i+" ");
            }
            out.println();
        }

        out.println();

        // Plot a half square
//        egg('X');

        out.println();

        // Plot a rhombus
        int k = 0;
        while (k <50) {
            for (int l = 0; l < k; l++) {
                out.print(" ");
            }
            for (int i =0; i < 10; i++) {
                out.print("X");
            }
            k++;
            out.println();
        }

    }
    void egg (char c) {
        int j = 1;
        while (j <50) {
            for (int i =0; i < j; i++) {
                out.print(c);
            }
            j++;
            out.println();
        }
    }
}
