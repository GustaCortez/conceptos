package org.prueba;

import java.util.List;

public interface TaskManager {
    void addTask(String description);
    void removeTask(int index);
    void completeTask(int index);
    List<Task> getPendingTasks();
    List<Task> getCompletedTasks();
}

