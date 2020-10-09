public class Circle extends Shape2D{
    private final double radius;

    // Create constructor take int input
    Circle(int radius) {
        super();
        this.radius = radius;
        this.name = "circle";
    }

    // Create constructor take double input
    Circle(double radius) {
        super();
        this.radius = radius;
        this.name = "circle";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

}
