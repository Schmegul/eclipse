package xerweek6.src.ex1inheritance;

public class Van extends Vehicle {

    private double maxCargo;

    public Van(Person owner, String id, double maxCargo) {
        super(id, owner);
        this.maxCargo = maxCargo;

    }

    @Override
    public String toString(){
      return "Van{maxCargo="+maxCargo
              +super.toString()
              +"}";
    }

}
