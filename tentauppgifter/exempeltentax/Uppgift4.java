package tentauppgifter.exempeltentax;

public class Uppgift4 {
    static int bound(int x, int a, int b) {
        return Math.min(b-1, Math.max(a,x));
    }
    void blur(int[][] a) {
        int[][] temp = new int[a.length][a[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                int sum = 0;
                for(int x = j-1; x <= j+1; x++) {
                    for(int y = i-1; y <= i+1; y++) {
                        sum += a[bound(y,0,a.length)][bound(x,0,a[i].length)];
                    }
                }
                temp[i][j] = sum / 9;
            }
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                a[i][j] = temp[i][j];
            }
        }
    }
}
