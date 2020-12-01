import java.io.IOException;
import java.util.Scanner;

public class ContactApp extends TaskApp {

    static void runContactList() throws Exception {
        Scanner scan = new Scanner(System.in);
        displayContactMainMenu();
        int ContactListMainInput;
        while (true) {
            ContactListMainInput = takeUserInputInt();
            if(ContactListMainInput == 1) {
                ContactList list = new ContactList();
                System.out.println("new contact list has been created\n");
                contactListOperationMenuPhase(list);
                displayContactMainMenu();
            }
            else if (ContactListMainInput == 2) {
                System.out.print("Enter the filename to load: ");
                String fileName = scan.nextLine();
                ContactList newList = new ContactList();

                boolean success = newList.loadList(fileName);
                if (success) {
                    System.out.println("task list has been loaded\n");
                    contactListOperationMenuPhase(newList);
                }
                displayContactMainMenu();
            }
            else if (ContactListMainInput == 3)
                break;
            else {
                System.out.println("Please enter a valid number 1-3");
            }
        }
    }

    private static void contactListOperationMenuPhase(ContactList list) throws IOException {
        displayContactListOperationMenu();
        int contactListOperationInput;
        while(true) {
            contactListOperationInput = takeUserInputInt();
            if (contactListOperationInput > 0 && contactListOperationInput < 6) {
                contactOperationMenu(contactListOperationInput, list);
                displayContactListOperationMenu();
            }
            else if (contactListOperationInput == 6)
                break;
            else {
                System.out.println("Please enter a valid number 1-6");
            }
        }
    }

    private static void contactOperationMenu(int contactListOperationInput, ContactList list) throws IOException {
        String firstName = null, lastName = null, phoneNumber = null, emailAddress = null;
        Scanner scan = new Scanner(System.in);
        switch (contactListOperationInput) {
            case 1:
                displayCurrentTasks();
                if (list.getSize() > 0) {
                    list.printList();
                }
                System.out.println("\n");
                break;

            case 2:
                ContactItem item = new ContactItem();

                System.out.println("First name: ");
                firstName = scan.nextLine();

                System.out.println("Last name: ");
                lastName = scan.nextLine();

                System.out.println("Phone number (xxx-xxx-xxxx): ");
                phoneNumber = scan.nextLine();

                System.out.println("Email address (x@y.z): ");
                emailAddress = scan.nextLine();

                item.setFirstName(firstName);
                item.setLastName(lastName);
                item.setPhoneNumber(phoneNumber);
                item.setEmailAddress(emailAddress);

                if (item.isEmptyInput()) {
                    System.out.println("Must enter a least one information");
                    break;
                }

                list.addContactItem(item);
                break;

            case 3:
                displayCurrentTasks();
                if (!printContactList(list))
                    break;

                System.out.println("\nWhich contact will you edit? ");
                int index = takeIndexInput(list.getSize());

                if (validContactIndex(index, list)) {
                    ContactItem newItem = new ContactItem();

                    System.out.println("Enter a new first name for contact " + index + ": ");
                    firstName = scan.nextLine();

                    System.out.println("Enter a new last name for contact " + index + ": ");
                    lastName = scan.nextLine();

                    System.out.println("Enter a new phone number (xxx-xxx-xxxx) for contact " + index + ": ");
                    phoneNumber = scan.nextLine();

                    System.out.println("Enter a new email address (x@y.z) for contact " + index + ": ");
                    emailAddress = scan.nextLine();

                    newItem.setFirstName(firstName);
                    newItem.setLastName(lastName);
                    newItem.setPhoneNumber(phoneNumber);
                    newItem.setEmailAddress(emailAddress);

                    if (newItem.isEmptyInput()) {
                        System.out.println("Must enter a least one information");
                        break;
                    }

                    list.editContactItem(index, newItem);
                }
                else
                    System.out.println("task index not exist");
                break;

            case 4:
                displayCurrentTasks();
                if (!printContactList(list))
                    break;

                System.out.println("\nWhich task will you remove");
                int removeIndex = takeIndexInput(list.getSize());

                if (!validContactIndex(removeIndex, list)) {
                    System.out.println("task index not exist");
                    break;
                }
                else
                    list.removeContactItem(removeIndex);
                break;

            case 5:
                System.out.println("Enter the filename to save as: ");
                String filename = scan.nextLine();
                if(list.saveList(filename))
                    System.out.println("test list has been saved");
                break;

        }
    }

    private static boolean validContactIndex(int index, ContactList list) {
        return (index >= 0) && (index < list.getSize());
    }

    private static boolean printContactList(ContactList list) {
        if (list.getSize() > 0) {
            list.printList();
            return true;
        }
        else {
            System.out.println("No item in the task list\n");
            return false;
        }
    }

    private static void displayContactListOperationMenu() {
        System.out.println("\nList Operation Menu");
        System.out.println("---------\n");
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu\n");
    }

    private static void displayContactMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("\n1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }


    protected static void displayCurrentTasks() {
        System.out.println("\nCurrent Contacts");
        System.out.println("-------------\n");
    }

}
