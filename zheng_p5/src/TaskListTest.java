import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize() throws Exception {
        TaskList list = new TaskList();
        for (int i = 0; i < 4; i++) {
            TaskItem item = new TaskItem();
            item.setTitle("title");
            item.setDueDate("2010-01-01");
            list.addTaskItem(item);
        }
        assertEquals(4, list.getSize());
    }

    @Test
    public void completingTaskItemChangesStatus() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        list.addTaskItem(item);
        list.markCompleteTaskItem(0);
        assertEquals(true, item.isComplete());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        list.addTaskItem(item);
        list.markCompleteTaskItem(7);
        assertEquals(false, item.isComplete());
    }

    @Test
    public void editingTaskItemChangesValues() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        TaskItem newItem = new TaskItem();
        newItem.setTitle("title change");
        newItem.setDueDate("2020-02-02");
        newItem.setDescription("task change");
        list.editTaskItem(0, newItem);
        assertEquals("[2020-02-02] title change: task change",list.getItem(0));
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editDescription(0, "task change");
        assertEquals("[2010-01-01] title: task change",list.getItem(0));
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editDescription(9, "task change");
        assertEquals("[2010-01-01] title: task",list.getItem(0));
    }

    @Test
    public void editingTaskItemDueDateChangesValue() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editDueDate(0, "2020-02-02");
        assertEquals("[2020-02-02] title: task",list.getItem(0));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editDueDate(8, "2020-02-02");
        assertEquals("[2010-01-01] title: task",list.getItem(0));
    }

    @Test
    public void editingTaskItemTitleChangesValue() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editTitle(0, "title change");
        assertEquals("[2010-01-01] title change: task",list.getItem(0));
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        list.editTitle(6, "title change");
        assertEquals("[2010-01-01] title: task",list.getItem(0));
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals(null,list.getDescription(8));
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals("task",list.getDescription(0));
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals(null,list.getDueDate(8));
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals("2010-01-01",list.getDueDate(0));
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals(null,list.getTitle(8));
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        item.setDescription("task");
        list.addTaskItem(item);

        assertEquals("title",list.getTitle(0));
    }

    @Test
    public void newTaskListIsEmpty() {
        TaskList list = new TaskList();
        assertEquals(0, list.getSize());
    }

    @Test
    public void removingTaskItemsDecreasesSize() throws Exception {
        TaskList list = new TaskList();
        for (int i = 0; i < 4; i++) {
            TaskItem item = new TaskItem();
            item.setTitle("title");
            item.setDueDate("2010-01-01");
            list.addTaskItem(item);
        }
        assertEquals(4, list.getSize());

        list.removeTaskItem(0);
        assertEquals(3, list.getSize());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        for (int i = 0; i < 4; i++) {
            TaskItem item = new TaskItem();
            item.setTitle("title");
            item.setDueDate("2010-01-01");
            list.addTaskItem(item);
        }
        assertEquals(4, list.getSize());

        list.removeTaskItem(90);
        assertEquals(4, list.getSize());
    }

    @Test
    public void unCompletingTaskItemChangesStatus() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        list.addTaskItem(item);
        list.markCompleteTaskItem(0);
        list.unMarkCompleteTaskItem(0);
        assertEquals(false, item.isComplete());
    }

    @Test
    public void unCompletingTaskItemFailsWithInvalidIndex() throws Exception {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem();
        item.setTitle("title");
        item.setDueDate("2010-01-01");
        list.addTaskItem(item);
        list.markCompleteTaskItem(0);
        list.unMarkCompleteTaskItem(9);
        assertEquals(true, item.isComplete());
    }
}