package motor;

public class MotorBike {

    //state
    private int speed; // member variable

    //constructors
    MotorBike() {
        this(5);
    }

    MotorBike(int speed) {
        this.speed = speed;
    }

    //behavior
    void setSpeed(int speed) {
        this.speed = speed;
    }

    int getSpeed() {
        return this.speed;
    }

    void start() {
        System.out.println("Bike started.");
    }

    void increaseSpeed(int howMuch) {
        setSpeed(this.speed = this.speed + howMuch);
    }

    void decreaseSpeed(int howMuch) {
        setSpeed(this.speed = this.speed - howMuch);

    }
}
