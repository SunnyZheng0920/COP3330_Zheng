
public class ContactItem extends TaskItem{
    private String firstName = null;
    private String lastName = null;
    private String phoneNumber = null;
    private String emailAddress = null;

    public ContactItem () {
        super();
    }

    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\n"
                + "Phone: " + getPhoneNumber() + "\n"
                + "Email: " + getEmailAddress();
    }

    @Override
    public String createTaskItem() {
        if (isEmptyInput())
                return null;
        else
            return toString();

    }

    public Boolean editSuccess (String firstName, String lastName, String phoneNumber, String emailAddress) {
        if(firstName.isEmpty() && lastName.isEmpty() && phoneNumber.isEmpty() && emailAddress.isEmpty()) {
            return false;
        }
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        return true;
    }

    public Boolean isEmptyInput (){
        return ((getFirstName().isEmpty()) && (getLastName().isEmpty())
                && (getPhoneNumber().isEmpty()) && (getEmailAddress().isEmpty()));
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
