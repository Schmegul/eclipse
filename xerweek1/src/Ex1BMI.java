import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.Math.*;


/*
 *
 * Program to calculate a persons BMI
 * See https://en.wikipedia.org/wiki/Body_mass_index
 *
 * Formula is: bmi = weight / height²     (kg/m²)
 *
 * See:
 * - ex1basics
 * - B6Slope in particular.
 */
public class Ex1BMI {

    // Don't care about this, must be there, start coding at program
    public static void main(String[] args) {
        new Ex1BMI().program();
    }

    // This connects our program to the keyboard
    final Scanner sc = new Scanner(in);

    void program() {
        double bmi;
        out.print("Please enter your weight (kg):");
        int weight = sc.nextInt();
        out.print("Please enter your height (m):");
        double height = sc.nextDouble();
        bmi = weight / pow(height,2);
        out.println(bmi);

    }

}
