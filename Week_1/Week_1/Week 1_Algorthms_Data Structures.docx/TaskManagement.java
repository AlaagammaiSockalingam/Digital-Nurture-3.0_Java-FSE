// Task class
class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

// Node class for singly linked list
class Node {
    private Task task;
    private Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

// SinglyLinkedList class
class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Add a new task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Search for a task by task ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId() == taskId) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null;
    }

    // Traverse the list and print all tasks
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.getTask().getTaskId());
            System.out.println("Task Name: " + current.getTask().getTaskName());
            System.out.println("Status: " + current.getTask().getStatus());
            System.out.println();
            current = current.getNext();
        }
    }

    // Delete a task by task ID
    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTask().getTaskId() == taskId) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }
}

// Main class
public class TaskManagement {
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Add tasks
        taskList.addTask(new Task(1, "Task 1", "Open"));
        taskList.addTask(new Task(2, "Task 2", "In Progress"));
        taskList.addTask(new Task(3, "Task 3", "Done"));

        // Traverse the list
        taskList.traverse();

        // Search for a task
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Task found: " + task.getTaskName());
        } else {
            System.out.println("Task not found");
        }

        // Delete a task
        taskList.deleteTask(2);

        // Traverse the list again
        taskList.traverse();
    }
}