public class Encrypter {
    String userInput;
    int i;
    int temp = 0;

    // Constructor
    public Encrypter() {
    }

    // Create instance method encrypt
    public String encrypt(String userInput) {

        // Converting String to int
        int fourDigitNumber = Integer.parseInt(userInput);

        // Declaring int array to store individual numbers
        int[] numbers = new int[4];

        // Sorting numbers
        for (i = 3; i >= 0; i--) {
            numbers[i] = fourDigitNumber % 10;
            fourDigitNumber = fourDigitNumber / 10;
        }

        for (i = 0; i < 4; i++) {
            numbers[i] = reminderOfAdd7(numbers[i]);
        }

        // Swap 1st number and 3rd number
        temp = numbers[0];
        numbers[0] = numbers[2];
        numbers[2] = temp;

        // Swap 2nd number and 4th number
        temp = numbers[1];
        numbers[1] = numbers[3];
        numbers[3] = temp;

        // Create array of string
        String[] stringNum = new String[4];

        for (i = 0; i < 4; i++) {
            stringNum[i] = Integer.toString(numbers[i]);
        }

        // Concatenate stings together to create a final result
        String encryptedValue = stringNum[0] + stringNum[1] + stringNum[2] + stringNum[3];

        return encryptedValue;
    }

    // Create a function that add 7 of to number and returns reminder
    public int reminderOfAdd7(int x) {
        return (x + 7) % 10;
    }

}
