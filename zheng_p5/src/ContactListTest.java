import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");

        assertEquals(0, list.getSize());

        list.addContactItem(item);
        assertEquals(1, list.getSize());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("");

        list.editContactItem(0, newItem);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {

        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("");

        // incorrect index
        list.editContactItem(3, newItem);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("");
        newItem.setLastName("Z");
        newItem.setPhoneNumber("123-123-1234");
        newItem.setEmailAddress("a@b.c");

        list.editContactItem(0, newItem);

        assertEquals("Name: " + "" + " " + "Z" + "\n"
                + "Phone: " + "123-123-1234" + "\n"
                + "Email: " + "a@b.c", list.getItemString(0));
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("Sunny");
        newItem.setLastName("");
        newItem.setPhoneNumber("123-123-1234");
        newItem.setEmailAddress("a@b.c");

        list.editContactItem(0, newItem);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "123-123-1234" + "\n"
                + "Email: " + "a@b.c", list.getItemString(0));
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("Sunny");
        newItem.setLastName("Z");
        newItem.setPhoneNumber("");
        newItem.setEmailAddress("a@b.c");

        list.editContactItem(0, newItem);

        assertEquals("Name: " + "Sunny" + " " + "Z" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "a@b.c", list.getItemString(0));
    }

    @Test
    public void editingSucceedsWithNonBlankValues() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");
        list.addContactItem(item);

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", list.getItemString(0));

        ContactItem newItem = new ContactItem();
        newItem.setFirstName("Sunny");
        newItem.setLastName("Z");
        newItem.setPhoneNumber("123-123-1234");
        newItem.setEmailAddress("a@b.c");

        list.editContactItem(0, newItem);

        assertEquals("Name: " + "Sunny" + " " + "Z" + "\n"
                + "Phone: " + "123-123-1234" + "\n"
                + "Email: " + "a@b.c", list.getItemString(0));
    }

    @Test
    public void newListIsEmpty() {
        ContactList list = new ContactList();
        assertEquals(0, list.getSize());
    }

    @Test
    public void removingItemsDecreasesSize() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");

        list.addContactItem(item);
        assertEquals(1, list.getSize());

        list.removeContactItem(0);
        assertEquals(0, list.getSize());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        ContactList list = new ContactList();
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");

        list.addContactItem(item);
        assertEquals(1, list.getSize());

        list.removeContactItem(1);
        assertEquals(1, list.getSize());
    }

    @Test
    public void savedContactListCanBeLoaded() {
        ContactList list = new ContactList();
        list.loadList("save.txt");

        ContactItem item1 = list.getContactItem(0);
        assertEquals("John", item1.getFirstName());
        assertEquals("Doe", item1.getLastName());
        assertEquals("555-123-1234", item1.getPhoneNumber());
        assertEquals("unKnown", item1.getEmailAddress());

        ContactItem item2 = list.getContactItem(1);
        assertEquals("ssss", item2.getFirstName());
        assertEquals("ssss", item2.getLastName());
        assertEquals("999-000-8888", item2.getPhoneNumber());
        assertEquals("jjjj@kkk.lll", item2.getEmailAddress());

    }

}