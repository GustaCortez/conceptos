package org.prueba;

import java.util.List;
import java.util.Scanner;

public class TaskApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManagerImpl();
        TaskStorage taskStorage = new TaskStorageImpl("tasks.ser");

        // Load tasks from storage
        List<Task> tasks = taskStorage.loadTasks();
        for (Task task : tasks) {
            taskManager.addTask(task.getDescription());
            if (task.isCompleted()) {
                taskManager.completeTask(tasks.indexOf(task));
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Complete Task");
            System.out.println("4. View Pending Tasks");
            System.out.println("5. View Completed Tasks");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();
                    new Thread(() -> taskManager.addTask(description)).start();
                    break;
                case 2:
                    System.out.println("Enter task index to remove:");
                    int removeIndex = scanner.nextInt();
                    new Thread(() -> taskManager.removeTask(removeIndex)).start();
                    break;
                case 3:
                    System.out.println("Enter task index to complete:");
                    int completeIndex = scanner.nextInt();
                    new Thread(() -> taskManager.completeTask(completeIndex)).start();
                    break;
                case 4:
                    List<Task> pendingTasks = taskManager.getPendingTasks();
                    System.out.println("Pending Tasks:");
                    for (int i = 0; i < pendingTasks.size(); i++) {
                        System.out.println(i + ". " + pendingTasks.get(i));
                    }
                    break;
                case 5:
                    List<Task> completedTasks = taskManager.getCompletedTasks();
                    System.out.println("Completed Tasks:");
                    for (int i = 0; i < completedTasks.size(); i++) {
                        System.out.println(i + ". " + completedTasks.get(i));
                    }
                    break;
                case 6:
                    taskStorage.saveTasks(taskManager.getPendingTasks());
                    taskStorage.saveTasks(taskManager.getCompletedTasks());
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

