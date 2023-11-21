package xerweek4.src;

import java.util.Arrays;

import static java.lang.System.out;

/*
 * Count number of words in some text
 *
 * See:
 *  - ex3string/
 *      S1Character
 *      S2String
 */
public class Ex1WordCount {

    public static void main(String[] args) {
        new Ex1WordCount().program();
    }

    void program() {
        // All should print true
//        out.println(countWords(" the among ss  so"));
//        /*
        out.println(countWords("") == 0);
        out.println(countWords("hello") == 1);
        out.println(countWords(" hello ") == 1);
        out.println(countWords("hello world") == 2);
        out.println(countWords("hello        world") == 2);
        out.println(countWords("   hello        world  ") == 2);
        String s = "Education is what remains after one has forgotten what one has learned in school.";
        out.println(countWords(s) == 14);
//        */
    }

    // ---------------- Methods -----------------------

    int countWords (String s) {
        String[] egg = s.split(" ");
        int empty = 0;
        for (int i = 0; i < egg.length; i++) {
            if (egg[i].isEmpty()) {
                empty++;
            }
        }

        return egg.length - empty;
    }

}
