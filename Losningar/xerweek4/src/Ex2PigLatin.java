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

    String toPigLatin(String text) {
        StringBuilder sb = new StringBuilder();
        for (String w : text.split(" ")) {
            if (isVowel(w.charAt(0))) {
                sb.append(w).append("way").append(" ");
            } else {
                int i = firstConsonant(w);
                String pre = w.substring(0, i);
                String post = w.substring(i);
                sb.append(post).append(pre).append("ay").append(" ");
            }
        }
        return sb.toString().trim();  // Trailing space!
    }

    // Helpers (English subset of this)
    boolean isVowel(char c) {
        return "aeiouyåäöAEIOUYÅÄÖ".indexOf(c) > -1;
    }

    int firstConsonant(String word) {
        int i = 0;
        while (i < word.length() && !isVowel(word.charAt(i))) {
            i++;
        }
        if( i >= word.length()){
            return -1;
        }
        return i;
    }


}
