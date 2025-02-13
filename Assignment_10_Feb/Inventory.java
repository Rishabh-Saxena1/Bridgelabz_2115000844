import java.util.Scanner;
class Item {
   String name;
   int id, quantity;
   double price;
   Item next;

   Item(String name, int id, int quantity, double price) {
       this.name = name;
       this.id = id;
       this.quantity = quantity;
       this.price = price;
       this.next = null;
   }
}

class Inventory {
   Item head;

   void addItemAtBeginning(String name, int id, int quantity, double price) {
       Item newItem = new Item(name, id, quantity, price);
       newItem.next = head;
       head = newItem;
   }

   void addItemAtEnd(String name, int id, int quantity, double price) {
       Item newItem = new Item(name, id, quantity, price);
       if (head == null) {
           head = newItem;
           return;
       }
       Item temp = head;
       while (temp.next != null) temp = temp.next;
       temp.next = newItem;
   }

   void addItemAtPosition(String name, int id, int quantity, double price, int position) {
       if (position <= 0) {
           addItemAtBeginning(name, id, quantity, price);
           return;
       }
       Item newItem = new Item(name, id, quantity, price);
       Item temp = head;
       for (int i = 1; temp != null && i < position; i++) temp = temp.next;
       if (temp == null) {
           addItemAtEnd(name, id, quantity, price);
           return;
       }
       newItem.next = temp.next;
       temp.next = newItem;
   }

   void removeItem(int id) {
       if (head == null) return;
       if (head.id == id) {
           head = head.next;
           return;
       }
       Item temp = head;
       while (temp.next != null && temp.next.id != id) temp = temp.next;
       if (temp.next != null) temp.next = temp.next.next;
   }

   void updateQuantity(int id, int quantity) {
       Item temp = head;
       while (temp != null) {
           if (temp.id == id) {
               temp.quantity = quantity;
               return;
           }
           temp = temp.next;
       }
   }

   Item searchById(int id) {
       Item temp = head;
       while (temp != null) {
           if (temp.id == id) return temp;
           temp = temp.next;
       }
       return null;
   }

   Item searchByName(String name) {
       Item temp = head;
       while (temp != null) {
           if (temp.name.equalsIgnoreCase(name)) return temp;
           temp = temp.next;
       }
       return null;
   }

   double calculateTotalValue() {
       double total = 0;
       Item temp = head;
       while (temp != null) {
           total += temp.price * temp.quantity;
           temp = temp.next;
       }
       return total;
   }

   void sortByName() {
       head = mergeSort(head, true);
   }

   void sortByPrice() {
       head = mergeSort(head, false);
   }

   Item mergeSort(Item head, boolean sortByName) {
       if (head == null || head.next == null) return head;
       Item middle = getMiddle(head);
       Item nextOfMiddle = middle.next;
       middle.next = null;
       Item left = mergeSort(head, sortByName);
       Item right = mergeSort(nextOfMiddle, sortByName);
       return merge(left, right, sortByName);
   }

   Item merge(Item left, Item right, boolean sortByName) {
       if (left == null) return right;
       if (right == null) return left;
       if ((sortByName && left.name.compareToIgnoreCase(right.name) < 0) || (!sortByName && left.price < right.price)) {
           left.next = merge(left.next, right, sortByName);
           return left;
       } else {
           right.next = merge(left, right.next, sortByName);
           return right;
       }
   }

   Item getMiddle(Item head) {
       if (head == null) return head;
       Item slow = head, fast = head;
       while (fast.next != null && fast.next.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
   }

   void displayInventory() {
       Item temp = head;
       while (temp != null) {
           System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
           temp = temp.next;
       }
   }
   public static void main(String[] args) {
       Inventory inventory = new Inventory();
       inventory.addItemAtEnd("pen", 101, 10, 50.5);
       inventory.addItemAtBeginning("paper", 102, 5, 30.0);
       inventory.addItemAtPosition("books", 103, 8, 40.0, 1);
       inventory.displayInventory();
       System.out.println("Total Value: " + inventory.calculateTotalValue());
       inventory.sortByName();
       System.out.println("Sorted by Name:");
       inventory.displayInventory();
   }
}
