import java.lang.Math;

public class BodyMassIndex {

    double height;
    double weight;
    double result;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBmiResult() {

        // Return the calculated bmi score in double
        result = 703 * this.weight / (this.height * this.height);
        result *= 10;
        result = Math.round(result);
        result = result / 10;

        return result;
    }

    public String calculateCategory() {

        // Store the bmi score in a variable
        double result = calculateBmiResult();

        // Apply score to return the corresponding category
        if (result <= 18.5 )
            return "Underweight\n";

        else if (result >= 18.5 && result <= 24.9)
            return "Normal weight\n";

        else if (result >= 25 && result <= 29.9)
            return "Overweight\n";

        else
            return "Obesity\n";
    }

    // This function simply display the score with one decimal
    public void displayScore() {
        double result = calculateBmiResult();
        System.out.printf("%.1f\n", result);
    }

    // This function simply display the corresponding category based on the bmi score
    public void displayCategoryResult() {
        String result = calculateCategory();
        System.out.println(result);
    }
}
