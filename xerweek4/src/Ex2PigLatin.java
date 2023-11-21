package xerweek4.src;

import java.util.Arrays;

import static java.lang.System.out;

/*
 *  Pig Latin, silly secret language
 *  https://en.wikipedia.org/wiki/Pig_Latin
 *
 *  See:
 * -  ex2shortforswitch/ShortForLoop
 *  - ex3string/
 *      S1Character
 *      S2String
 *      S3StringBuilder
 */
public class Ex2PigLatin {

    public static void main(String[] args) {
        new Ex2PigLatin().program();
    }

    void program() {
        // Should print true
        out.println(toPigLatin("My name is Eric")
                .equals("yMay amenay isway Ericway"));
    }

    // ---------- Methods --------------------

    String toPigLatin (String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String text : arr) {
            if (isVowel(text.charAt(0))) {
                sb.append(text).append("way ");

            }   else {
                int j = numOfCons(text);
                String pre = text.substring(0,j);
                String post = text.substring(j);
                sb.append(post).append(pre).append("ay ");
                }
        }

        return sb.toString().trim();
    }

    boolean isVowel (char c) {
        return "eyuioaåöäEYUIOAÅÖÄ".indexOf(c) > -1;
    }

    int numOfCons (String s) {
        int i = 0;

        while (i < s.length() && !isVowel(s.charAt(i))) {
            i++;
        }
        if (i >= s.length()) {
            return -1;
        }

        return i;
    }
    // split at " " and put into array. check first of every object ->
    //    if vowel -> add append "way"
    //    if consonant -> check if next is consonant
    //      take all consonants till first vow, substring them away
    //      and append them + "ay"

}
