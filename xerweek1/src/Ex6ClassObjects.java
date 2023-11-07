import java.util.Scanner;

import static java.lang.System.*;

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
        Hero hero1 = new Hero();
        String winner;

        out.print("What's the name of the hero 1? >");
        hero1.name = sc.nextLine();
        out.print("How strong is " + hero1.name + " >");
        hero1.strength = sc.nextInt();
        sc.nextLine();

        Hero hero2 = new Hero();
        out.print("What's the name of the hero 2? >");
        hero2.name = sc.nextLine();
        out.print("How strong is " + hero2.name + " >");
        hero2.strength = sc.nextInt();

        // ------- Output --------------
        if (hero1.strength < hero2.strength){
            out.println(hero2.name + " is stronger");
        }   else if (hero1.strength > hero2.strength) {
            out.println(hero1.name + " is stronger");
        }   else {
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
