import java.util.ArrayList;

public class TaskList {
    private int size = 0, completedTaskItem = 0;
    private ArrayList <TaskItem> taskList = new ArrayList<>();

    public TaskList(){

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addTaskItem (TaskItem item) {
        taskList.add(item);
        setSize(getSize() + 1);
    }

    public void printList() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            TaskItem item = taskList.get(i);
            System.out.println( i + ") " + item.createTaskItem());
        }
    }

    public void printUncompletedList() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            TaskItem item = taskList.get(i);
            if(item.isComplete() == false)
                System.out.println( i + ") " + item.createTaskItem());
        }
    }

    public void printCompletedList() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            TaskItem item = taskList.get(i);
            if(item.isComplete() == true)
                System.out.println( i + ") " + item.createTaskItem());
        }
    }

    public String getItem(int index) {
        TaskItem item = taskList.get(index);
        return item.createTaskItem();
    }


    public void editTaskItem (int index, TaskItem newItem)
    {
        taskList.set(index, newItem);
    }

    public void editDescription (int index, String newDescription) {
        if (index < 0 || index > getSize()) {
            return;
        }
        TaskItem item = taskList.get(index);
        item.setDescription(newDescription);
    }

    public void editTitle (int index, String newTitle) throws Exception {
        if (index < 0 || index > getSize()) {
            return;
        }
        TaskItem item = taskList.get(index);
        item.setTitle(newTitle);
    }

    public void editDueDate (int index, String newDueDate) throws Exception {
        if (index < 0 || index > getSize()) {
            return;
        }
        TaskItem item = taskList.get(index);
        item.setDueDate(newDueDate);
    }

    public String getDescription (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        TaskItem item = taskList.get(index);
        return item.getDescription();
    }

    public String getDueDate (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        TaskItem item = taskList.get(index);
        return item.getDueDate();
    }

    public String getTitle (int index) {
        if (index < 0 || index > getSize()) {
            return null;
        }
        TaskItem item = taskList.get(index);
        return item.getTitle();
    }

    public void removeTaskItem (int index) {
        if (index < 0 || index > getSize()) {
            return;
        }
        taskList.remove(index);
        setSize(getSize() - 1);
    }

    public void markCompleteTaskItem(int completeIndex) {
        if (completeIndex < 0 || completeIndex > getSize()) {
            return;
        }
       TaskItem item = taskList.get(completeIndex);
       item.setComplete(true);
       setCompletedTaskItem(getCompletedTaskItem() + 1);
    }

    public void unMarkCompleteTaskItem(int unMarkCompleteIndex) {
        if (unMarkCompleteIndex < 0 || unMarkCompleteIndex > getSize()) {
            return;
        }
        TaskItem item = taskList.get(unMarkCompleteIndex);
        item.setComplete(false);
        setCompletedTaskItem(getCompletedTaskItem() - 1);
    }

    public int getCompletedTaskItem() {
        return completedTaskItem;
    }

    public void setCompletedTaskItem(int completedTaskItem) {
        this.completedTaskItem = completedTaskItem;
    }

}
