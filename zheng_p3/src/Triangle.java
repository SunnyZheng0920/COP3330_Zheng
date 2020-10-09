public class Triangle extends Shape2D {
    private final double base;
    private final double height;

    // Create constructor with int input
    Triangle(int base, int height) {
        super();
        this.base = base;
        this.height = height;
        this.name = "triangle";
    }

    // Create constructor take double input
    Triangle(double base, double height) {
        super();
        this.base = base;
        this.height = height;
        this.name = "triangle";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return this.base * this.height / 2;
    }

}
