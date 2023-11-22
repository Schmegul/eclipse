package Losningar.xerweek4.src;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/*
 *  Using Steinhaus-Johnson-Trotter (non-recursive) algorithm for permutations
 *  See https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm
 *
 * See
 * - ex3string
 * - ex5collections
 *
 */
public class Ex8SJT {

    public static void main(String[] args) {
        new Ex8SJT().program();
    }

    private void program() {
        // Call permutation method
        List<String> perms = permutationSJT("123456");

        out.println(perms.size());  // 720
        for (String s : perms) {
            out.println(s);
        }

        int count = 0;
        for (String s : perms) {
            if (s.equals("123456")) {
                count++;
            }
        }
        out.println(count == 1);
    }

    // Steinhaus–Johnson–Trotter permutation algorithm iterative!
    // Use functional decomposition!
    List<String> permutationSJT(String set) {
        List<String> perms = new ArrayList<>();
        if (set.length() == 1) {
            perms.add(set);
            return perms;
        }
        perms.addAll(insertFromRight(set.substring(0, 1), set.charAt(1)));
        if (set.length() == 2) {
            return perms;
        }
        for (int i = 2; i < set.length(); i++) {
            perms = insert(perms, set.charAt(i));
        }
        return perms;
    }

    List<String> insert(List<String> sets, char ch) {
        List<String> ps = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++) {
            // NOTE: Will always start from right!
            if (i % 2 == 0) {
                ps.addAll(insertFromRight(sets.get(i), ch));
            } else {
                ps.addAll(insertFromLeft(sets.get(i), ch));
            }
        }
        return ps;
    }

    List<String> insertFromLeft(String set, char elem) {
        List<String> ins = new ArrayList<>();
        for (int i = 0; i < set.length(); i++) {
            String pre = set.substring(0, i);
            String post = set.substring(i);
            ins.add(pre + elem + post);
        }
        ins.add(set + elem);
        return ins;
    }

    List<String> insertFromRight(String set, char elem) {
        List<String> ins = new ArrayList<>();
        for (int i = set.length(); i > 0; i--) {
            String pre = set.substring(0, i);
            String post = set.substring(i);
            ins.add(pre + elem + post);
        }
        ins.add(elem + set);
        return ins;
    }
}