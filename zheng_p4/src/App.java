import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main (String[] args) throws FileNotFoundException {
        displayMainMenu();
        try {
            int userInputInMain = takeMainMenuInput();
            while (userInputInMain != 3) {
                if (userInputInMain == 1) {
                    TaskList list = new TaskList();
                    System.out.println("new task list has been created\n");

                    operationMenuPhase(list);
                    displayMainMenu();
                    userInputInMain = takeMainMenuInput();
                } else if (userInputInMain == 2) {
                    System.out.print("Enter the filename to load: ");

                    // scan file and put in a new TaskList
                    String fileName = scan.nextLine();
                    TaskList newList = new TaskList();
                    readFile(fileName, newList);

                    System.out.println("task list has been loaded");

                    operationMenuPhase(newList);
                    displayMainMenu();
                    userInputInMain = takeMainMenuInput();
                } else {
                    System.out.println("Please enter a valid number(1, 2, or 3) :");
                    displayMainMenu();
                    userInputInMain = scan.nextInt();
                }
            }
        }catch (InputMismatchException inputMismatchException) {
            System.out.println("Please enter a valid number(1-8) :");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not exist, please run again");
        }catch (Exception e) {
            System.out.println("Error, please run again");
        }
    }

    // load file into a new TaskList functions
    private static void readFile(String fileName, TaskList newList) throws Exception {
        // Open file
        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);
        ArrayList<String> stringList = new ArrayList<>();

        // adding String to the array list
        while (fileScan.hasNextLine()) {
            stringList.add(fileScan.nextLine());
        }

        // scan string and put in the new TaskList
        scanString(stringList, newList);
    }

    // helper function for reading file
    private static void scanString(ArrayList<String> stringList, TaskList newList) throws Exception {
        for (int i = 0; i < stringList.size(); i++) {
            String dataString = stringList.get(i);
            TaskItem item = new TaskItem();

            // check if is completed
            if (dataString.contains("*** ")) {
                item.setComplete(true);
            }
            int indexStatus = setItemDueDateData(dataString, item);
            indexStatus = setItemTitleData(indexStatus, dataString, item);
            setItemDescriptionData(indexStatus, dataString, item);

            newList.addTaskItem(item);
        }
    }
    private static void setItemDescriptionData(int indexStatus, String dataString, TaskItem item) {
        String data = "";
        Boolean flag = false;
        int i = indexStatus;

        for(; i < dataString.length(); i++) {
            if (i == indexStatus + 1) {
                flag = true;
                continue;
            }
            if (flag) {
                data += dataString.charAt(i);
            }
        }
        item.setDescription(data);
    }
    private static int setItemTitleData(int indexStatus, String dataString, TaskItem item) throws Exception {
        String data = "";
        Boolean flag = false;
        int i = indexStatus;

        int end = dataString.indexOf(':');

        for(; i < dataString.length(); i++) {
            if (i == indexStatus + 1) {
                flag = true;
                continue;
            }
            else if (i == end) {
                item.setTitle(data);
                break;
            }
            if (flag) {
                data += dataString.charAt(i);
            }
        }
        return i;
    }
    private static int setItemDueDateData(String dataString, TaskItem item) throws Exception {
        String data = "";
        Boolean flag = false;
        int i = 0;

        int open = dataString.indexOf('[');
        int end = dataString.indexOf(']');

        for(i = 0; i < dataString.length(); i++) {
            if (i == open) {
                flag = true;
                continue;
            }
            else if (i == end) {
                item.setDueDate(data);
                break;
            }
            if (flag) {
                data += dataString.charAt(i);
            }
        }
        return i;
    }


    // take input functions
    private static int takeOperationMenuInputHelper() {
        try {
            Scanner operationMenuScan = new Scanner(System.in);
            int x = operationMenuScan.nextInt();
            if (x <= 0 || x > 8)
                throw new Exception("Please enter a valid number(1-8) :");
            return x;
        }catch (Exception e) {
            System.out.println("Please enter a valid number(1-8) :");
            return 0;
        }
    }
    private static int takeOperationMenuInput() {
        Boolean shouldContinue = true;
        int resultFromHelper = takeOperationMenuInputHelper();
        while (shouldContinue) {
            if (resultFromHelper == 0) {
                resultFromHelper = takeOperationMenuInputHelper();
            }
            else
                shouldContinue = false;
        }
        return resultFromHelper;
    }
    private static int takeMainMenuInputHelper() {
        try {
            Scanner mainMenuScan = new Scanner(System.in);
            int x = mainMenuScan.nextInt();
            if (x <= 0 || x > 3)
                throw new Exception("Please enter a valid number(1, 2, or 3) :");
            return x;
        }catch (Exception e) {
            System.out.println("Please enter a valid number(1, 2, or 3) :");
            return 0;
        }
    }
    private static int takeMainMenuInput() {
            Boolean shouldContinue = true;
        int resultFromHelper = takeMainMenuInputHelper();
        while (shouldContinue) {
            if (resultFromHelper == 0) {
                resultFromHelper = takeMainMenuInputHelper();
            }
            else
                shouldContinue = false;
        }
        return resultFromHelper;
    }
    private static int takeIndexInputHelper() {
        try {
            Scanner indexScan = new Scanner(System.in);
            return indexScan.nextInt();
        }catch (Exception e) {
            System.out.println("Please enter a valid task index");
            return -10;
        }
    }
    private static int takeIndexInput(int size) {
        Boolean shouldContinue = true;
        int resultFromHelper = takeIndexInputHelper();
        while (shouldContinue) {
            if (resultFromHelper == -10) {
                resultFromHelper = takeIndexInputHelper();
            }
            else if (resultFromHelper > size){
                System.out.println("Please enter a valid task index");
                resultFromHelper = takeIndexInputHelper();
            }
            else
                shouldContinue = false;
        }
        return resultFromHelper;
    }


    // display functions
    public static void displayMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("\n1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }
    public static void displayOperationMenu() {
        System.out.println("\nList Operation Menu");
        System.out.println("---------");
        System.out.println("\n1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
    }
    public static void displayCurrentTasks() {
        System.out.println("\nCurrent Tasks");
        System.out.println("-------------\n");
    }
    public static void displayUncompletedTask() {
        System.out.println("\nUncompleted Tasks");
        System.out.println("-------------\n");
    }
    public static void displayCompletedTask() {
        System.out.println("\nCompleted Tasks");
        System.out.println("-------------\n");
    }


    // check functions
    private static Boolean validIndex(int index, TaskList list) { return (index >= 0) || (index < list.getSize()); }
    private static Boolean checkSize(TaskList list) {
        return list.getSize() > 0;
    }
    private static boolean correctInput(String title, String dueDate) {
        return title != null && dueDate != null;
    }


    // printing functions
    private static Boolean printList (TaskList list) {
        if (checkSize(list)) {
            list.printList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }
    private static Boolean printUncompletedList (TaskList list) {
        if (checkSize(list)) {
            list.printUncompletedList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }
    private static Boolean printCompletedList (TaskList list) {
        if (checkSize(list)) {
            list.printCompletedList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }

    // keep calling operation menu until user enter 8
    private static void operationMenuPhase(TaskList list) {
        displayOperationMenu();
        int userInputInOperation = takeOperationMenuInput();
        while (userInputInOperation != 8) {
            try {
                operationMenu(userInputInOperation, list);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            displayOperationMenu();
            userInputInOperation = takeOperationMenuInput();
        }
    }

    // Interact with user in the operation phase by using switch
    public static void operationMenu(int operationMenuSelection, TaskList list) throws Exception {
        Scanner scan = new Scanner(System.in);
        switch (operationMenuSelection) {
            case 1:
                displayCurrentTasks();

                if (list.getSize() > 0) {
                    list.printList();
                }
                else {
                    System.out.println("\n");
                }
                break;

            case 2:
                displayCurrentTasks();

                TaskItem item = new TaskItem();

                String title = null, description = null, dueDate = null;

                    System.out.print("Task title: ");
                    title =  scan.nextLine();

                    System.out.println("Task description: ");
                    description = scan.nextLine();

                    System.out.println("Task due date (YYYY-MM-DD): ");
                    dueDate = scan.nextLine();

                if (correctInput(title, dueDate)) {
                    item.setTitle(title);
                    item.setDescription(description);
                    item.setDueDate(dueDate);
                    list.addTaskItem(item);
                }
                break;

            case 3:
                displayCurrentTasks();
                if (!printList(list))
                    break;

                System.out.println("Which task will you edit? ");
                int index = takeIndexInput(list.getSize());

                if (!validIndex(index, list)) {
                    System.out.println("task index not exist");
                }
                else {
                    TaskItem newItem = new TaskItem();

                    System.out.print("Enter a new title for task " + index + ": ");
                    String newTitle = scan.nextLine();
                    newItem.setTitle(newTitle);

                    System.out.println("Enter a new description for task " + index + ": ");
                    String newDescription = scan.nextLine();
                    newItem.setDescription(newDescription);

                    System.out.println("Enter a new task due date for task " + index + ": ");
                    String newDueDate = scan.nextLine();
                    newItem.setDueDate(newDueDate);

                    list.editTaskItem(index, newItem);

                }
                break;

            case 4:
                displayCurrentTasks();
                if (!printList(list))
                    break;

                System.out.println("Which task will you remove");
                int removeIndex =  takeIndexInput(list.getSize());

                if (!validIndex(removeIndex, list)) {
                    System.out.println("task index not exist");
                }
                else
                    list.removeTaskItem(removeIndex);
                break;


            case 5:
                displayUncompletedTask();
                if (!printUncompletedList(list))
                    break;

                System.out.println("Which task will you mark as complete? ");
                    int completeIndex = takeIndexInput(list.getSize());

                    if (!validIndex(completeIndex, list)) {
                        System.out.println("task index not exist");
                    }
                    else
                        list.markCompleteTaskItem(completeIndex);

                    break;


            case 6:
                displayCompletedTask();
                if (!printCompletedList(list))
                    break;

                System.out.println("Which task will you un-mark as complete? ");
                int unMarkCompleteIndex = takeIndexInput(list.getSize());
                if (!validIndex(unMarkCompleteIndex, list)) {
                    System.out.println("task index not exist");
                }
                else
                    list.unMarkCompleteTaskItem(unMarkCompleteIndex);

                break;

            case 7:
                System.out.println("Enter the filename to save as: ");
                String filename = scan.nextLine();
                String fileContent = "";
                for (int i = 0; i < list.getSize(); i++) {
                    fileContent = fileContent.concat(i + ") " + list.getItem(i) + "\n");
                }
                FileWriter writer = new FileWriter(filename);
                writer.write(fileContent);
                writer.close();

                System.out.println("test list has been saved");
                break;
        }
    }
}
