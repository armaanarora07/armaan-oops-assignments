// Interface Vehicle
interface Vehicle {
    void start();
    void stop();
    double getFuelLevel();
}

// Concrete class Car
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public double getFuelLevel() {
        return 0.75; // 75% fuel level
    }
}

// Concrete class Motorcycle
class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

    @Override
    public double getFuelLevel() {
        return 0.5; // 50% fuel level
    }
}

// Main class
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        car.start();
        motorcycle.start();

        car.stop();
        motorcycle.stop();

        System.out.println("Car fuel level: " + car.getFuelLevel());
        System.out.println("Motorcycle fuel level: " + motorcycle.getFuelLevel());
    }
}
