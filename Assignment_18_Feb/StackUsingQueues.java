import java.util.*;
class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        queue1.add(x);
    }
    public int pop() {
        if (queue1.isEmpty()) throw new NoSuchElementException("Stack is empty!");
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int poppedElement = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poppedElement;
    }

    public int top() {
        if (queue1.isEmpty()) throw new NoSuchElementException("Stack is empty!");
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        int topElement = queue1.poll();
        queue2.add(topElement);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top Element: " + stack.top());
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Top Element after pop: " + stack.top());
        System.out.println("Is Stack Empty? " + stack.isEmpty());
    }
}
