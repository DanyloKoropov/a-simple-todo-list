package org.example;

import java.util.ArrayList;


public class TodoList {

    private final ArrayList<String> pendingTasks = new ArrayList<String>();
    private final ArrayList<String> completedTasks = new ArrayList<String>();


    //for tests
    public ArrayList<String> getPendingTasks() {
        return pendingTasks;
    }
    public ArrayList<String> getCompletedTasks() {
        return completedTasks;
    }

    public void add(String newTask) {
        if (newTask == null || newTask.isBlank()) {
            System.out.println("Task can`t be null or blank!");
        } else if (pendingTasks.contains(newTask)) {
            System.out.println("You already have this task!");
        } else {
            pendingTasks.add(newTask);
        }

    }

    public String all() {
        return "Current tasks: " + pendingTasks +
                "\nCompleted tasks: " + completedTasks;
    }

    public void complete(String newTask) {
        if (pendingTasks.contains(newTask)) {
            completedTasks.add(newTask);
            pendingTasks.remove(newTask);
        } else {
            System.out.println("You don`t have this task!");
        }
    }

    public ArrayList<String> complete() {
        return completedTasks;
    }

    public ArrayList<String> incomplete() {
        return pendingTasks;
    }

    public void clear() {
        pendingTasks.clear();
        completedTasks.clear();
    }


}