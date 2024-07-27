package org.prueba;

import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl implements TaskManager {
    private final List<Task> tasks;

    public TaskManagerImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public synchronized void addTask(String description) {
        tasks.add(new Task(description));
    }

    @Override
    public synchronized void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    @Override
    public synchronized void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
        }
    }

    @Override
    public synchronized List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    @Override
    public synchronized List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
}

