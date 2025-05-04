package Experiment5;
abstract class Vehicle {
    private String make;
    private String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public abstract void startEngine();

    public abstract void stopEngine();

    public void serviceInfo() {
        System.out.println("Service every 6 months for " + make + " " + model);
    }
}

class Car extends Vehicle {
    public Car(String make, String model) {
        super(make, model);
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped.");
    }
}

class Main5
 {
    public static void main(String[] args) {
        Car car = new Car("Tata", "Nano");
        car.startEngine();
        car.stopEngine();
        car.serviceInfo();
    }
}