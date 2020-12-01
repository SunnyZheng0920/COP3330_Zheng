import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList extends TaskList{
    private ArrayList<ContactItem> contactList = new ArrayList<>();
    private int size = 0;

    public ContactList() {
        super();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    public String getItemString(int index) {
        ContactItem item = contactList.get(index);
        return item.createTaskItem();
    }

    public ContactItem getContactItem(int index) {
        ContactItem item = contactList.get(index);
        return item;
    }

    public String getFirstName (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        ContactItem item = contactList.get(index);
        return item.getFirstName();
    }

    public String getLastName (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        ContactItem item = contactList.get(index);
        return item.getLastName();
    }

    public String getPhoneNumber (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        ContactItem item = contactList.get(index);
        return item.getPhoneNumber();
    }

    public String getEmailAddress (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        ContactItem item = contactList.get(index);
        return item.getEmailAddress();
    }

    public void addContactItem (ContactItem item) {
        contactList.add(item);
        setSize(getSize() + 1);
    }

    @Override
    public void printList() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            ContactItem item = contactList.get(i);
            System.out.println( i + ") " + item.createTaskItem());
        }
    }

    public void editContactItem (int index, ContactItem newItem)
    {
        try {
            if (newItem.isEmptyInput()) {
                return;
            }
            contactList.set(index, newItem);
        }catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("task index not exist, please try again");
        }
    }

    public void removeContactItem (int index) {
        try {
            if (index < 0 || index >= getSize()) {
                return;
            }
            contactList.remove(index);
            setSize(getSize() - 1);
        }catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("task index not exist, please try again");
        }
    }

    @Override
    public Boolean saveList (String fileName)  {
        String fileContent = "";
        try {
            for (int i = 0; i < this.getSize(); i++) {
                fileContent = fileContent.concat(this.getFirstName(i) + "\n" + this.getLastName(i)+ "\n"
                        + this.getPhoneNumber(i) + "\n" + this.getEmailAddress(i) + "\n");
            }
            FileWriter writer;
            writer = new FileWriter(fileName);
            writer.write(fileContent);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error opening file. File not saved");
            return false;
        }
    }

    @Override
    public boolean loadList (String fileName) {
        File file = new File(fileName);
        try {
            Scanner fileScan = new Scanner(file);
            while (fileScan.hasNextLine()) {
                ContactItem item = new ContactItem();
                item.setFirstName(fileScan.nextLine());
                item.setLastName(fileScan.nextLine());
                item.setPhoneNumber(fileScan.nextLine());
                item.setEmailAddress(fileScan.nextLine());
                addContactItem(item);
            }
            return true;
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Wrong Enter! File not found");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
