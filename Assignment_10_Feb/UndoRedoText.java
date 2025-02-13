import java.util.*;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class UndoRedoText {
    TextState current;
    int maxSize;
    int size;

    UndoRedoText(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.current = null;
    }

    void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }
        current = newState;
        size++;
        if (size > maxSize) {
            TextState temp = current;
            while (temp.prev != null) temp = temp.prev;
            temp.next.prev = null;
            temp.next = null;
            size--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available");
        }
    }
    public static void main(String[] args) {
        UndoRedoText editor = new UndoRedoText(10);
        editor.addState("Hi..I am Gogo");
        editor.addState("I am student!!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
