package xerweek5.src.ex2usemoreclasses;

import java.util.Objects;

/*
      A class for a Triangle in 3D
      Should use Point class and Herons formula

      NOTE: No IO here, this is just the logical concept.

      To test run Ex2TestPointTriangle

 * See:
 * - ex1classes/
 * - ex2oomodels/
*/
public class Triangle {

    private final Point x;
    private final Point y;
    private final Point z;

    public Triangle(Point x, Point y, Point z) {
        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
        this.z = Objects.requireNonNull(z);
    }

    public double area() {
        double k = 0.5*(x.distance(y)+y.distance(z)+z.distance(x));
        return k;
        //Area={\sqrt {s\left(s-a\right)\left(s-b\right)\left(s-c\right)
    }
}

