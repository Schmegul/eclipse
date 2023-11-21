package Losningar.xerweek4.src;

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
        out.println(countWords("") == 0);
        out.println(countWords("hello") == 1);
        out.println(countWords(" hello ") == 1);
        out.println(countWords("hello world") == 2);
        out.println(countWords("hello        world") == 2);
        out.println(countWords("   hello        world  ") == 2);
        String s = "Education is what remains after one has forgotten what one has learned in school.";
        out.println(countWords(s) == 14);

    }

    int countWords(String text) {
        int count = 0;
        text = text.trim();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i)) ||
                    text.charAt(i) == text.charAt(text.length() - 1)) {
                count++;
                while (Character.isWhitespace(text.charAt(i)) && i < text.length() - 1) {
                    i++;
                }
            }
        }
        return count;
    }

    // Alternative (better but we don't want to go to much into regexps)
    int countWords2(String text) {
        String[] wordArray = text.trim().split(" ");
        int count = 0;
        for (String s : wordArray) {
            if (s.length() > 0) {
                count++;
            }
        }
        return count;
    }

}
