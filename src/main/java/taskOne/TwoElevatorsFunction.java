package taskOne;

public class TwoElevatorsFunction {

    private int totalFloors;
    private Elevator elevatorA;
    private Elevator elevatorB;

    public TwoElevatorsFunction(int totalFloors) {
        this.totalFloors = totalFloors;
        this.elevatorA = new Elevator("A", 0);
        this.elevatorB = new Elevator("B", totalFloors / 2);
    }

    public void requestElevator(int floor) {
        Elevator closestElevator = divideAndConquerElevator(floor, elevatorA, elevatorB);
        closestElevator.moveTo(floor);
        System.out.println("Elevator " + closestElevator.getName() + " is moving to floor " + floor);
    }

    private Elevator divideAndConquerElevator(int floor, Elevator leftElevator, Elevator rightElevator) {
        int midFloor = (leftElevator.getCurrentFloor() + rightElevator.getCurrentFloor()) / 2;

        if (floor <= midFloor) {
            if (leftElevator.getCurrentFloor() == midFloor) {
                return leftElevator;
            } else {
                return divideAndConquerElevator(floor, leftElevator, new Elevator("B", midFloor));
            }
        } else {
            if (rightElevator.getCurrentFloor() == midFloor) {
                return rightElevator;
            } else {
                return divideAndConquerElevator(floor, new Elevator("A", midFloor + 1), rightElevator);
            }
        }
    }

    public static void main(String[] args) {
        TwoElevatorsFunction elevatorsFunction = new TwoElevatorsFunction(19);
        elevatorsFunction.requestElevator(1);
        elevatorsFunction.requestElevator(17);
        elevatorsFunction.requestElevator(8);
    }
}
