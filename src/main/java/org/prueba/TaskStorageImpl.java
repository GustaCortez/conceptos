package org.prueba;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskStorageImpl implements TaskStorage {
    private final String fileName;

    public TaskStorageImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveTasks(List<Task> tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}

