package fromweek2.beforeafter;

/*
 *   Before, call, after
 */
public class BA5 {

    public static void main(String[] args) {
        new BA5().program();
    }

    void program() {
       B b1 = new B( 1, "a");
       A a1 = new A( 2, b1 );   // Before
       B b2 = doIt( a1 );      // Call
                             // After

    }

    B doIt( A a ){
        a.i = 99;
        a.b.s = "b";
        return a.b;
    }

    class A {
        int i;
        B b;
        A( int i, B b ){
            this.i = i;
            this.b = b;
        }
    }

    class B {
        int i;
        String s;
        B ( int i, String s ){
            this.i = i;
            this.s = s;
        }

    }

}
