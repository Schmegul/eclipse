import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ex5classes
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // -------- Input ------------
        Hero h1 = new Hero();
        out.print("What's the name of the hero 1? > ");
        h1.name = sc.nextLine();
        out.print("How strong is " + h1.name + " > ");
        h1.strength = sc.nextInt();
        sc.nextLine();   // Read away enter

        Hero h2 = new Hero();
        out.print("What's the name of the hero 2? > ");
        h2.name = sc.nextLine();
        out.print("How strong is " + h2.name + " > ");
        h2.strength = sc.nextInt();

        // ------- Output --------------
        if (h1.strength > h2.strength) {
            out.println(h1.name + " is stronger");
        } else if (h1.strength < h2.strength){
            out.println(h2.name + " is stronger");
        } else {
           out.println("They are equally strong");
        }
    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}
