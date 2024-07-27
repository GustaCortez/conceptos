Estructura del Proyecto
TaskManager: Interfaz para la gestión de tareas.
TaskManagerImpl: Implementación de TaskManager.
Task: Clase que representa una tarea.
TaskStorage: Interfaz para el almacenamiento de tareas.
TaskStorageImpl: Implementación de TaskStorage.
TaskApp: Clase principal que contiene la interfaz de usuario y la gestión de hilos.

Explicación de la Implementación
Concurrencia: Se utilizan hilos (new Thread(() -> ...).start()) para realizar operaciones en la lista de tareas de manera concurrente.
Distribución de Componentes: La aplicación está dividida en componentes de gestión de tareas (TaskManager y TaskManagerImpl), almacenamiento de datos (TaskStorage y TaskStorageImpl), y la interfaz de usuario (TaskApp).
Separación de Interfaz e Implementación: Se utilizan interfaces (TaskManager y TaskStorage) para definir los contratos entre los componentes, permitiendo cambiar la implementación sin afectar la interfaz del usuario.
![image](https://github.com/user-attachments/assets/77c86322-1bdf-4f78-a8f9-0ac368151bbd)


