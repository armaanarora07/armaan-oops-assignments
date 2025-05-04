// Abstract class Solid
abstract class Solid {
    abstract double calculateVolume();
}

// Concrete class Cuboid
class Cuboid extends Solid {
    private double length, width, height;

    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateVolume() {
        return length * width * height;
    }
}

// Concrete class Sphere
class Sphere extends Solid {
    private double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}

// Main class
public class SolidVolumeCalculator {
    public static void main(String[] args) {
        Solid cuboid = new Cuboid(2, 3, 4);
        Solid sphere = new Sphere(5);

        System.out.println("Cuboid volume: " + cuboid.calculateVolume());
        System.out.println("Sphere volume: " + sphere.calculateVolume());
    }
}
