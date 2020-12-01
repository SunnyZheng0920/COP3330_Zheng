import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TaskItem {
    private String title = null;
    private String  description = null;
    private String dueDate = null;
    private boolean complete = false;

    public TaskItem () {

    }

    public String checkTitle (String title) {
        try {
            if (title == null || title.isEmpty()) {
                return null;
            }
            return title;
        }catch (Exception ex) {
            return null;
        }
    }
    public void setTitle(String title) throws Exception {
        String correctTitle = checkTitle(title);
        if (correctTitle == null) {
            throw new Exception("WARNING: title must be at least 1 character long, task not created");
        }
            this.title = checkTitle(title);
    }

    public void setDueDate(String dueDate) throws Exception {
        String correctFormattedDueDate = checkDueDateFormat(dueDate);
        if (correctFormattedDueDate == null || correctFormattedDueDate.isEmpty()) {
            throw new Exception("WARNING: invalid due date; task not created");
        }
            this.dueDate = correctFormattedDueDate;
    }

    // helper function for set due date
    public String checkDueDateFormat(String dueDate) {
        Boolean wrongInput = false;
        try {
            String pattern = "yyyy-MM-dd";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
            LocalDate date = LocalDate.parse(dueDate, dateFormatter);
            dueDate = date.toString();
            return dueDate;

        }catch (Exception ex) {
            return null;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String createTaskItem() {
        if ((getTitle() == null) || (getDueDate() == null))
            return null;

        if (isComplete())
            return returnMarkForComplete() + "[" + getDueDate() + "]" + " " + getTitle() + ": " + getDescription();
        else
            return "[" + getDueDate() + "]" + " " + getTitle() + ": " + getDescription();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean decision) {
        this.complete = decision;
    }

    private String returnMarkForComplete() {
        return "*** ";
    }
}
