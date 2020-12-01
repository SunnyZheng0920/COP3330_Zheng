import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        ContactItem item = new ContactItem();
        item.setFirstName("");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");

        assertEquals(true, item.isEmptyInput());
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem();
        item.setEmailAddress("");

        assertEquals("", item.getEmailAddress());
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem();
        item.setFirstName("");

        assertEquals("", item.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem();
        item.setLastName("");

        assertEquals("", item.getLastName());
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem();
        item.setPhoneNumber("");

        assertEquals("", item.getPhoneNumber());
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("");
        item.setPhoneNumber("");
        item.setEmailAddress("");

        assertEquals("Name: " + "Sunny" + " " + "" + "\n"
                + "Phone: " + "" + "\n"
                + "Email: " + "", item.createTaskItem());
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem item = new ContactItem();
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String emailAddress = "";

        assertEquals(false, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem item = new ContactItem();
        String firstName = "Sunny";
        String lastName = "Z";
        String phoneNumber = "123-123-1234";
        String emailAddress = "";

        assertEquals(true, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem item = new ContactItem();
        String firstName = "";
        String lastName = "Z";
        String phoneNumber = "123-123-1234";
        String emailAddress = "a@b.c";

        assertEquals(true, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem item = new ContactItem();
        String firstName = "Sunny";
        String lastName = "";
        String phoneNumber = "123-123-1234";
        String emailAddress = "a@b.c";

        assertEquals(true, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem item = new ContactItem();
        String firstName = "Sunny";
        String lastName = "Z";
        String phoneNumber = "";
        String emailAddress = "a@b.c";

        assertEquals(true, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem item = new ContactItem();
        String firstName = "Sunny";
        String lastName = "Z";
        String phoneNumber = "123-123-1234";
        String emailAddress = "a@b.c";

        assertEquals(true, item.editSuccess(firstName, lastName, phoneNumber, emailAddress));
    }

    @Test
    public void testToString(){
        ContactItem item = new ContactItem();
        item.setFirstName("Sunny");
        item.setLastName("Z");
        item.setPhoneNumber("123-123-1234");
        item.setEmailAddress("a@b.c");

        assertEquals("Name: " + "Sunny" + " " + "Z" + "\n"
                + "Phone: " + "123-123-1234" + "\n"
                + "Email: " + "a@b.c", item.toString());
    }

}