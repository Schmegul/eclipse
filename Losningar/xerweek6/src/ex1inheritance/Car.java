package Losningar.xerweek6.src.ex1inheritance;

import javafx.scene.paint.Color;

public class Car extends Vehicle {

    private double topSpeed;

    public Car(Person owner, String id, double topSpeed) {
        super(owner, id);
        this.topSpeed = topSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                 super.toString() + '}';
    }
}
