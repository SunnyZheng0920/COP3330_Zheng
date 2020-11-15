import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() throws Exception {
        TaskItem item = new TaskItem();
        item.setDescription("1");
        item.setTitle("title");
        assertThrows(Exception.class, () -> item.setDueDate(""));
        String answer = item.createTaskItem();
        assertEquals(null, answer);
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() throws Exception {
        TaskItem item = new TaskItem();
        item.setDueDate("2020-02-02");
        item.setDescription("1");
        assertThrows(Exception.class, () -> item.setTitle(""));
        String answer = item.createTaskItem();
        assertEquals(null, answer);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() throws Exception {
        TaskItem item = new TaskItem();
        item.setDueDate("2020-02-02");
        item.setDescription("1");
        item.setTitle("title");
        String answer = item.createTaskItem();
        assertEquals("[2020-02-02] title: 1", answer);
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() throws Exception {
        TaskItem item = new TaskItem();
        item.setDueDate("2020-02-02");
        item.setDescription("1");
        item.setTitle("title");
        String answer = item.createTaskItem();
        assertEquals("[2020-02-02] title: 1", answer);
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        TaskItem item = new TaskItem();
        assertThrows(Exception.class, () -> item.setDueDate(""));
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() throws Exception {
        TaskItem item = new TaskItem();
        item.setDueDate("2020-02-02");
        String answer = item.getDueDate();
        assertEquals("2020-02-02", answer);
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        TaskItem item = new TaskItem();
        assertThrows(Exception.class, () -> item.setTitle(""));
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() throws Exception {
        TaskItem item = new TaskItem();
        item.setTitle("title");
        String answer = item.getTitle();
        assertEquals("title", answer);
    }

}