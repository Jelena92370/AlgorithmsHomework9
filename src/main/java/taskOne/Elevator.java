package taskOne;

public class Elevator {

    private String name;
    private int currentFloor;

    public Elevator(String name, int currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
    }

    public String getName() {
        return name;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveTo(int targetFloor) {


        currentFloor = targetFloor;
    }
}