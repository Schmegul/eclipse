package xerweek6.src.ex1inheritance;

import javafx.scene.paint.Color;

import java.util.Random;

public abstract class Vehicle {

    private String id;
    private Person owner;
    public Vehicle(String id, Person owner) {
        this.id = id;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{owner="+owner
                +"}, id="
                +id+"}";
    }

}
