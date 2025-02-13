import java.util.*;
class Process {
   int id, burstTime, priority, remainingTime;
   Process next;
 
   Process(int id, int burstTime, int priority) {
       this.id = id;
       this.burstTime = burstTime;
       this.priority = priority;
       this.remainingTime = burstTime;
       this.next = null;
   }
}

class RoundRobinAlgo {
   Process head = null, tail = null;
   int timeQuantum;

   RoundRobinAlgo(int timeQuantum) {
       this.timeQuantum = timeQuantum;
   }

   void addProcess(int id, int burstTime, int priority) {
       Process newProcess = new Process(id, burstTime, priority);
       if (head == null) {
           head = tail = newProcess;
           tail.next = head;
       } else {
           tail.next = newProcess;
           tail = newProcess;
           tail.next = head;
       }
   }

   void removeProcess(int id) {
       if (head == null) return;
       Process temp = head, prev = null;
       do {
           if (temp.id == id) {
               if (temp == head) {
                   tail.next = head.next;
                   head = head.next;
               } else if (temp == tail) {
                   prev.next = tail.next;
                   tail = prev;
               } else {
                   prev.next = temp.next;
               }
               return;
           }
           prev = temp;
           temp = temp.next;
       } while (temp != head);
   }

   void executeProcesses() {
       if (head == null) return;
       int time = 0, totalWaitingTime = 0, totalTurnaroundTime = 0, count = 0;
       Process current = head;
       while (head != null) {
           if (current.remainingTime > 0) {
               int executeTime = Math.min(timeQuantum, current.remainingTime);
               time += executeTime;
               current.remainingTime -= executeTime;
               if (current.remainingTime == 0) {
                   totalWaitingTime += time - current.burstTime;
                   totalTurnaroundTime += time;
                   removeProcess(current.id);
                   count++;
               }
           }
           current = current.next;
           displayProcesses();
           if (head == null) break;
       }
       System.out.println("Average Waiting Time: " + (double) totalWaitingTime / count);
       System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / count);
   }

   void displayProcesses() {
       if (head == null) return;
       Process temp = head;
       System.out.print("Processes: ");
       do {
           System.out.print("ID: " + temp.id + " Remaining: " + temp.remainingTime);
           temp = temp.next;
       } while (temp != head);
       System.out.println();
   }
   public static void main(String[] args) {
       RoundRobinAlgo s = new RoundRobinAlgo(3);
       s.addProcess(1, 10, 0);
       s.addProcess(1, 3, 2);
       s.addProcess(1, 2, 1);
       s.executeProcesses();
   }
}
