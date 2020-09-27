import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput() {
        boolean result;

        // Promote the user to make a decision
        System.out.println("Enter Y to continue use the program, enter N to exit");
        Scanner userInput = new Scanner(System.in);

        // Scan and store user's decision
        String userChoice = userInput.nextLine();

        // return a correct boolean variable based on user's input
        if (userChoice.equalsIgnoreCase("Y")) {
            result = true;
        }
        else if (userChoice.equalsIgnoreCase("N")) {
            result = false;
        }
        else
            result = false;
        return result;
    }

    static double getUserHeight() {

        // Promote the user to enter a height in inches
        System.out.println("Please enter your height in inches: ");

        // Scan the user input and return the value in double
        Scanner getHeight = new Scanner(System.in);
        double height = getHeight.nextDouble();

        while (height < 0) {
            System.out.println("Please enter a positive number.");
            height = getHeight.nextDouble();
        }

        return height;
    }

    static double getUserWeight() {

        // Promote the user to enter a weight in lb
        System.out.println("Please enter your weight in lb: ");

        // Scan the user input and return the value in double
        Scanner getWeight = new Scanner(System.in);
        double weight = getWeight.nextDouble();

        while (weight < 0) {
            System.out.println("Please enter a positive number.");
            weight = getWeight.nextDouble();
        }

        return weight;
    }

    static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

        double sum = 0;
        BodyMassIndex scoreInIndex;

        // Add every values that are added to the arraylist
        for (int i = 0; i < bmiData.size(); i++) {
            scoreInIndex = bmiData.get(i);
            sum += scoreInIndex.calculateBmiResult();
        }

        // Calculate the average and return the result with one decimal
        double average = sum / bmiData.size();
        System.out.print("The average is: ");
        System.out.printf("%.1f", average);
    }

    // Display the calculated bmi score and corresponding category
    static void displayBmiInfo(BodyMassIndex bmi)
    {
        bmi.displayScore();
        bmi.displayCategoryResult();
    }
}
