public class Decrypter {
    String userInput;
    int i;
    int temp = 0;

    // Constructor
    public Decrypter() {

    }

    // Create instance method decrypt
    public String decrypt(String userInput) {

        // Converting String to int
        int fourDigitNumber = Integer.parseInt(userInput);

        // Declaring int array to store individual numbers
        int[] numbers = new int[4];

        // Sorting numbers
        for (i = 3; i >= 0; i--) {
            numbers[i] = fourDigitNumber % 10;
            fourDigitNumber = fourDigitNumber / 10;
        }

        // Swap 1st number and 3rd number
        temp = numbers[0];
        numbers[0] = numbers[2];
        numbers[2] = temp;

        // Swap 2nd number and 4th number
        temp = numbers[1];
        numbers[1] = numbers[3];
        numbers[3] = temp;

        for (i = 0; i < 4; i++) {
            numbers[i] = reminderOfSubtract7(numbers[i]);
        }

        // Create array of string
        String[] stringNum = new String[4];

        for (i = 0; i < 4; i++) {
            stringNum[i] = Integer.toString(numbers[i]);
        }

        // Concatenate stings together to create a final result
        String decryptedValue = stringNum[0] + stringNum[1] + stringNum[2] + stringNum[3];

        return decryptedValue;
    }

    public int reminderOfSubtract7(int x) {
        if ((x - 7) >= 0) {
            return x - 7;
        }
        else {
            return x - 7 + 10;
        }

    }
    public void swap(int x, int y) {

    }
}
