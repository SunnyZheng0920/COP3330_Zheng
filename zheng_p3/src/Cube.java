public class Cube extends Shape3D{
    private final double sideLength;

    // Create constructor take int input
    Cube(int sideLength) {
        super();
        this.sideLength = sideLength;
        this.name = "cube";
    }

    // Create constructor take double input
    Cube(double sideLength) {
        super();
        this.sideLength = sideLength;
        this.name = "cube";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return Math.pow(this.sideLength, 2) * 6;
    }

    @Override
    public double getVolume() {
        return Math.pow(this.sideLength, 3);
    }
}
