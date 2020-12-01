import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        TaskApp taskApp = new TaskApp();
        ContactApp contactApp = new ContactApp();
        displayApplicationMenu();
        int applicationInput;
        while (true) {
            applicationInput = takeUserInputInt();
            if (applicationInput == -1 || applicationInput == 0) {
                System.out.println("Please enter a valid number 1-3");
            }
            else if (applicationInput == 1) {
                taskApp.runTaskList();
                displayApplicationMenu();
            }
            else if (applicationInput == 2) {
                contactApp.runContactList();
                displayApplicationMenu();
            }
            else if (applicationInput == 3)
                break;
            else {
                System.out.println("Please enter a valid number 1-3");
            }
        }
    }

    // display helpers
    private static void displayApplicationMenu() {
        System.out.println("Select Your Application");
        System.out.println("-----------------------\n");
        System.out.println("1) task list");
        System.out.println("2) contact list");
        System.out.println("3) quit\n");
    }

    private static int takeUserInputInt() {
        try{
            Scanner applicationScan = new Scanner(System.in);
            return applicationScan.nextInt();
        }catch (InputMismatchException inputMismatchException) {
            return -1;
        }
    }

}
