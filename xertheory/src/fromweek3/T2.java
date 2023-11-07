package fromweek3;


/*
         Which rows compile and which doesn't? Why?
         Try to predict then uncomment.
 */

public class T2 {

    public static void main(String[] args) {
        new T2().program();
    }

    void program() {
        Integer[] is = {1, 2, 3};
        Double[] ds = {1.0, 2.0, 3.0};
        Object o = null;
        Object[] os = null;
        Integer i;

        //o = is;                      // 1
        //o[0]++;                    // 2
        //os = is;                   // 3
        //os[0]++;                   // 4
        //os = (Object[]) is;        // 5
        //ds = (Double[]) os;        // 6
        //os = ds;                   // 7
        // ds = (Double[]) os;        // 8
        //i = os[0];                 // 9
        // i = (Integer) os[0];       // 10

    }


}
