package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoListTest {
    @Test
    void listAdd() {

        TodoList list = new TodoList();
        list.add("Task1");
        assertEquals(1, list.getPendingTasks().size());
        assertEquals("Task1", list.getPendingTasks().get(0));
        list.add("Task2");
        list.add("Task3");
        assertEquals(3, list.getPendingTasks().size());
        assertEquals("Task1", list.getPendingTasks().get(0));
        assertEquals("Task2", list.getPendingTasks().get(1));
        assertEquals("Task3", list.getPendingTasks().get(2));
    }
    @Test
    void listAll() {

        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        list.add("Task3");
        assertEquals("Current tasks: [Task1, Task2, Task3]\n" +
                "Completed tasks: []", list.all());
    }
    @Test
    void listComplete() {

        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        list.add("Task3");
        list.complete("Task2");
        assertEquals("Current tasks: [Task1, Task3]\n" +
                "Completed tasks: [Task2]", list.all());

    }

    @Test
    void listCompleteOnly() {

        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        list.add("Task3");
        list.complete("Task2");
        assertEquals("Task2", list.getCompletedTasks().get(0));
    }

    @Test
    void listIncomplete() {

        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        list.add("Task3");
        list.complete("Task2");
        assertEquals("Task1", list.getPendingTasks().get(0));
        assertEquals("Task3", list.getPendingTasks().get(1));
    }

    @Test
    void clear() {

        TodoList list = new TodoList();
        list.add("Task1");
        list.add("Task2");
        list.add("Task3");
        list.complete("Task2");
        list.clear();

        assertEquals(0, list.getPendingTasks().size());
        assertEquals(0, list.getCompletedTasks().size());

    }

    @Test
    void completeTaskThatDoesNotExist() {

        TodoList list = new TodoList();

        list.add("Task1");
        list.add("Task2");
        list.add("Task3");

        list.complete("Task4");

        assertEquals(3, list.getPendingTasks().size());
        assertEquals(0, list.getCompletedTasks().size());

        assertEquals("Task1", list.getPendingTasks().get(0));
        assertEquals("Task2", list.getPendingTasks().get(1));
        assertEquals("Task3", list.getPendingTasks().get(2));
    }

    @Test
    void addEmpty() {

        TodoList list = new TodoList();
        list.add(null);
        list.add("");
        list.add(" ");
        list.add("     \n");
        assertEquals(0, list.getPendingTasks().size());
    }

    @Test
    void rejectDuplicatePendingTask() {
        TodoList list = new TodoList();

        list.add("Task1");
        list.add("Task1");

        assertEquals(1, list.getPendingTasks().size());
    }

    @Test
    void allowDuplicateCompletedTask() {
        TodoList list = new TodoList();

        list.add("Task1");
        list.complete("Task1");
        list.add("Task1");

        assertEquals(1, list.getPendingTasks().size());
        assertEquals(1, list.getCompletedTasks().size());
    }

}
