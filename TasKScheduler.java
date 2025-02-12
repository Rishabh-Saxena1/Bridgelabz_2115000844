import java.util.*;
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TasKScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    void removeTaskById(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Task temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next.taskId == taskId) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
    }

    void viewCurrentTask() {
        if (currentTask == null) currentTask = head;
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (ID: " + currentTask.taskId + ")");
            currentTask = currentTask.next;
        }
    }

    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task found: " + temp.taskName + " (ID: " + temp.taskId + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("task not found" + priority);
    }

    public static void main(String[] args) {
        TasKScheduler s = new TasKScheduler();
        s.addTaskAtEnd(1, "swim", 3, "2025-06-15");
        s.addTaskAtEnd(2, "run", 1, "2025-06-20");
        s.addTaskAtBeginning(3, "shopping", 2, "2025-06-10");
        s.addTaskAtPosition(4, "skincare", 4, "2025-06-25", 2);
        s.displayTasks();
        System.out.println("Current Tasks:");
        s.viewCurrentTask();
        s.viewCurrentTask();
        System.out.println("Searching for Task with Priority 2:");
        s.searchTaskByPriority(2);
        System.out.println("Removing Task with ID");
        s.removeTaskById(3);
        s.displayTasks();
    }
}
