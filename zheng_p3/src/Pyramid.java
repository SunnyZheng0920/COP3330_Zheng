public class Pyramid extends Shape3D {
    private final double length;
    private final double width;
    private final double height;

    // Create constructor take int input
    Pyramid(int length, int width, int height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = "pyramid";
    }

    // Create constructor take double input
    Pyramid(double length, double width, double height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = "pyramid";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getArea() {
        return (this.length * this.width) + (this.length * Math.sqrt(Math.pow(this.width / 2, 2)
                + Math.pow(this.height, 2)))
                + (this.width * Math.sqrt(Math.pow(this.length / 2, 2) + Math.pow(this.height, 2)));
    }

    @Override
    public double getVolume() {
        return (this.length * this.width * this.height) / 3;
    }

}
