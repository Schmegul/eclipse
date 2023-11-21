package Losningar.xerweek3.src;

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
        for (int r = 1; r <= 10; r++) {
            for (int c = 1; c <= 10 ; c++) {
                if( r * c < 10 ){
                    out.print(" ");
                }
                out.print( r * c + " " );
            }
            out.println();
        }

        // Plot a half square
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                out.print("X");
            }
            out.println();
        }

        out.println();

        // Plot a rhombus
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < r; c++) {
                out.print(" ");
            }
            for (int c = r; c < 10 + r; c++) {
                out.print("X");
            }
            out.println();
        }


    }
}
