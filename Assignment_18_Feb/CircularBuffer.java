import java.util.*;
class CircularBuffer {
    private int[] buffer;
    private int front, rear, size, capacity;
    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }
    public void enqueue(int value) {
        if (isFull()) {
            front = (front + 1) % capacity;
        }
        else if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        buffer[rear] = value;
        size = Math.min(size + 1, capacity);
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty!");
        }
        int removedValue = buffer[front];
        if (front == rear) {
            front = -1;
            rear = -1;
            size = 0;
        }
        else {
            front = (front + 1) % capacity;
            size--;
        }
        return removedValue;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Buffer is empty!");
        }
        return buffer[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Buffer is empty!");
            return;
        }

        System.out.print("Circular Buffer: ");
        int index = front;
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[index] + " ");
            index = (index + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(5);
        cb.enqueue(10);
        cb.enqueue(20);
        cb.enqueue(30);
        cb.enqueue(40);
        cb.enqueue(50);

        cb.display();

        cb.enqueue(60);
        cb.display();
        System.out.println("Dequeued: " + cb.dequeue());
        cb.display();

        cb.enqueue(70);
        cb.display();

        System.out.println("Peek: " + cb.peek());
    }
}
