import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    static void runTaskList() throws Exception {
        Scanner scan = new Scanner(System.in);
        displayTaskMainMenu();
        int taskListMainInput;
        while(true) {
            taskListMainInput = takeUserInputInt();
            if (taskListMainInput == 1) {
                TaskList list = new TaskList();
                System.out.println("new task list has been created\n");
                TaskListOperationMenuPhase(list);
                displayTaskMainMenu();
            }
            else if (taskListMainInput == 2) {
                System.out.print("Enter the filename to load: ");
                String fileName = scan.nextLine();
                TaskList newList = new TaskList();

                boolean success = newList.loadList(fileName);
                if (success) {
                    System.out.println("task list has been loaded");
                    TaskListOperationMenuPhase(newList);
                }
                displayTaskMainMenu();
            }
            else if (taskListMainInput == 3)
                break;
            else {
                System.out.println("Please enter a valid number 1-3");
            }
        }
    }

    private static void TaskListOperationMenuPhase(TaskList list) throws Exception {
        displayTaskListOperationMenu();
        int taskListOperationInput;
        while(true) {
            taskListOperationInput = takeUserInputInt();
            if (taskListOperationInput > 0 && taskListOperationInput < 8) {
                operationMenu(taskListOperationInput, list);
                displayTaskListOperationMenu();
            }
            else if (taskListOperationInput == 8)
                break;
            else {
                System.out.println("Please enter a valid number 1-8");
            }
        }
    }

    private static void operationMenu(int operationMenuSelection, TaskList list) throws Exception {
        Scanner scan = new Scanner(System.in);
        switch (operationMenuSelection) {
            case 1:
                displayCurrentTasks();

                if (list.getSize() > 0) {
                    list.printList();
                } else {
                    System.out.println("\n");
                }
                break;

            case 2:
                displayCurrentTasks();

                TaskItem item = new TaskItem();

                String title = null, description = null, dueDate = null;

                System.out.print("Task title: ");
                title =  scan.nextLine();
                title = item.checkTitle(title);

                System.out.println("Task description: ");
                description = scan.nextLine();

                System.out.println("Task due date (YYYY-MM-DD): ");
                dueDate = scan.nextLine();
                dueDate = item.checkDueDateFormat(dueDate);

                try {
                    item.setTitle(title);
                    item.setDescription(description);
                    item.setDueDate(dueDate);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                if (correctInput(title, dueDate)) {
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
                    break;
                }
                else {
                    TaskItem newItem = new TaskItem();

                    System.out.print("Enter a new title for task " + index + ": ");
                    String newTitle = scan.nextLine();
                    newTitle = newItem.checkTitle(newTitle);

                    System.out.println("Enter a new description for task " + index + ": ");
                    String newDescription = scan.nextLine();

                    System.out.println("Enter a new task due date for task " + index + ": ");
                    String newDueDate = scan.nextLine();
                    newDueDate = newItem.checkDueDateFormat(newDueDate);

                    try {
                        newItem.setTitle(newTitle);
                        newItem.setDescription(newDescription);
                        newItem.setDueDate(newDueDate);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                    if (correctInput(newTitle, newDueDate)) {
                        list.editTaskItem(index, newItem);
                    }
                }
                break;

            case 4:
                displayCurrentTasks();
                if (!printList(list))
                    break;

                System.out.println("Which task will you remove");
                int removeIndex = takeIndexInput(list.getSize());

                if (!validIndex(removeIndex, list)) {
                    break;
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
                    break;
                }
                else
                    list.unMarkCompleteTaskItem(unMarkCompleteIndex);
                break;

            case 7:
                System.out.println("Enter the filename to save as: ");
                String filename = scan.nextLine();
                if(list.saveList(filename))
                    System.out.println("test list has been saved");
                break;
        }
    }

    protected static int takeUserInputInt() {
        try{
            Scanner applicationScan = new Scanner(System.in);
            return applicationScan.nextInt();
        }catch (InputMismatchException inputMismatchException) {
            return -1;
        }
    }

    protected static int takeIndexInput(int size) {
        int indexInput;
        while (true) {
            try {
                indexInput = takeUserInputInt();
                if (indexInput < 0 || indexInput >= size) {
                    System.out.println("Please enter a valid task index");
                } else
                    return indexInput;
            }catch (Exception e) {
                System.out.println("Please enter a valid task index");
            }
        }
    }

    private static boolean validIndex(int index, TaskList list) {
        return (index >= 0) && (index < list.getSize());
    }

    private static boolean correctInput(String title, String dueDate) {
        return title != null && dueDate != null;
    }

    private static boolean printList(TaskList list) {
        if (list.getSize() > 0) {
            list.printList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }
    private static Boolean printUncompletedList (TaskList list) {
        if (list.getSize() > 0) {
            list.printUncompletedList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }
    private static Boolean printCompletedList (TaskList list) {
        if (list.getSize() > 0) {
            list.printCompletedList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }

    protected static void displayTaskMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("\n1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }

    private static void displayTaskListOperationMenu() {
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

    protected static void displayCurrentTasks() {
        System.out.println("\nCurrent Tasks");
        System.out.println("-------------\n");
    }
    private static void displayUncompletedTask() {
        System.out.println("\nUncompleted Tasks");
        System.out.println("-------------\n");
    }
    private static void displayCompletedTask() {
        System.out.println("\nCompleted Tasks");
        System.out.println("-------------\n");
    }
}
