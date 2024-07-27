package org.prueba;

import java.util.List;

public interface TaskStorage {
    void saveTasks(List<Task> tasks);
    List<Task> loadTasks();
}

