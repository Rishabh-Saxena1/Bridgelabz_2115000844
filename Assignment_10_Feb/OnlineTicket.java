class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class OnlineTicket {
    Ticket last;
    int size;

    OnlineTicket() {
        this.last = null;
        this.size = 0;
    }

    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        size++;
    }

    void removeTicket(int ticketId) {
        if (last == null) return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) last = prev;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    void displayTickets() {
        if (last == null) return;
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    Ticket searchTicket(String keyword) {
        if (last == null) return null;
        Ticket temp = last.next;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) return temp;
            temp = temp.next;
        } while (temp != last.next);
        return null;
    }

    int getTotalTickets() {
        return size;
    }
    public static void main(String[] args) {
        OnlineTicket trs = new OnlineTicket();
        trs.addTicket(1, "rahul", "DDLJ", "A1", "10:00 AM");
        trs.addTicket(2, "RiGo", "Pushpa", "B2", "12:00 PM");
        trs.displayTickets();
        trs.removeTicket(1);
        System.out.println("Tickets after removing");
        trs.displayTickets();
        System.out.println("Total no. of tickets: " + trs.getTotalTickets());
    }
}
