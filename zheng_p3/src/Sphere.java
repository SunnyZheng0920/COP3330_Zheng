public class Sphere extends Shape3D{
    private final double radius;

    // Create constructor take int input
    Sphere(int radius) {
        super();
        this.radius = radius;
        this.name = "sphere";
    }

    // Create constructor take double input
    Sphere(double radius) {
        super();
        this.radius = radius;
        this.name = "sphere";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }
}
