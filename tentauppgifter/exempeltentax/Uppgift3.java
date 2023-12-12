package tentauppgifter.exempeltentax;

import static java.lang.System.*;
public class Uppgift3 {

    public static void main(String[] args) { new Uppgift3().program();}

    void program() {
        int j = parityCount2(new int[]{1, 2, 3, 4, 5, 4, 4, 4, 5});
        out.println(j);
    }
    public static int parityCount ( int[] arr) {    // method 1
        int evenCounter = 0;
        int[] visited = new int[arr.length];
        int visitCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int seen = 1;
            int b = arr[i];
            if (!contains(visited, visitCount, b)) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == b) {
                        seen++;
                    }
                }
                if (seen % 2 == 0) {
                    evenCounter++;
                }
                visited[visitCount++] = b;
            }
        }

        return evenCounter;
    }
    public static int parityCount2 ( int[] arr) {   // method 2
        int evenCounter = 0;
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                int seen = 1;
                int b = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == b) {
                        seen++;
                        visited[j] = true;
                    }
                }
                if (seen % 2 == 0) {
                    evenCounter++;
                }
            }
        }
        return evenCounter;
    }


    private static boolean contains ( int[] arr, int length, int v){    // used by method 1
        for (int i = 0; i < length; i++) {
            if (arr[i] == v) {
                return true;
            }
        }
        return false;
    }
}

