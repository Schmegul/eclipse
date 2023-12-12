package Losningar.xerweek6.src.ex1inheritance;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Vehicle {

    private Person owner;
    private final String id;

    public Vehicle(Person owner, String id) {
        this.owner = owner;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "owner=" + owner +
                ", id='" + id + '\'' +
                '}';
    }
}
