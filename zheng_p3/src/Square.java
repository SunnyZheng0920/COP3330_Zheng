public class Square extends Shape2D {
    private final double sideLength;

    // Create constructor take int input
    Square(int sideLength) {
        super();
        this.sideLength = sideLength;
        this.name = "square";
    }

    // Create constructor take double input
    Square(double sideLength) {
        super();
        this.sideLength = sideLength;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return this.sideLength * this.sideLength;
    }
}
