class Movie {
   String title;
   String director;
   int year;
   double rating;
   Movie next, prev;

   public Movie(String title, String director, int year, double rating) {
       this.title = title;
       this.director = director;
       this.year = year;
       this.rating = rating;
       this.next = this.prev = null;
   }
}

class MovieManagementSystem {
   private Movie head, tail;

   public void addMovieAtBeginning(String title, String director, int year, double rating) {
       Movie newMovie = new Movie(title, director, year, rating);
       if (head == null) {
           head = tail = newMovie;
       } else {
           newMovie.next = head;
           head.prev = newMovie;
           head = newMovie;
       }
   }

   public void addMovieAtEnd(String title, String director, int year, double rating) {
       Movie newMovie = new Movie(title, director, year, rating);
       if (tail == null) {
           head = tail = newMovie;
       } else {
           tail.next = newMovie;
           newMovie.prev = tail;
           tail = newMovie;
       }
   }

   public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
       if (position <= 0) {
           addMovieAtBeginning(title, director, year, rating);
           return;
       }
       Movie newMovie = new Movie(title, director, year, rating);
       Movie temp = head;
       for (int i = 0; temp != null && i < position - 1; i++) {
           temp = temp.next;
       }
       if (temp == null || temp.next == null) {
           addMovieAtEnd(title, director, year, rating);
       } else {
           newMovie.next = temp.next;
           temp.next.prev = newMovie;
           temp.next = newMovie;
           newMovie.prev = temp;
       }
   }

   public void removeMovie(String title) {
       Movie temp = head;
       while (temp != null) {
           if (temp.title.equals(title)) {
               if (temp.prev != null) temp.prev.next = temp.next;
               if (temp.next != null) temp.next.prev = temp.prev;
               if (temp == head) head = temp.next;
               if (temp == tail) tail = temp.prev;
               return;
           }
           temp = temp.next;
       }
   }

   public void searchByDirector(String director) {
       Movie temp = head;
       while (temp != null) {
           if (temp.director==director) {
               System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
           }
           temp = temp.next;
       }
   }

   public void searchByRating(double rating) {
       Movie temp = head;
       while (temp != null) {
           if (temp.rating == rating) {
               System.out.println(temp.title + " directed by " + temp.director);
           }
           temp = temp.next;
       }
   }

   public void updateRating(String title, double newRating) {
       Movie temp = head;
       while (temp != null) {
           if (temp.title.equals(title)) {
               temp.rating = newRating;
               return;
           }
           temp = temp.next;
       }
   }

   public void displayForward() {
       Movie temp = head;
       while (temp != null) {
           System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
           temp = temp.next;
       }
   }

   public void displayReverse() {
       Movie temp = tail;
       while (temp != null) {
           System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
           temp = temp.prev;
       }
   }
   public static void main(String[] args) {
       MovieManagementSystem obj = new MovieManagementSystem();
       obj.addMovieAtBeginning("DDLJ", "Yash Chopra", 2006, 10.0);
       obj.addMovieAtEnd("shaitaan", "Christopher", 2014, 8.6);
       obj.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2000, 9.0);
       obj.addMovieAtPosition("Avatar", "James Cameron", 2009, 7.8, 1);
       System.out.println("Forward Order:");
       obj.displayForward();
       System.out.println("Reverse Order:");
       obj.displayReverse();
       System.out.println("Searching for movies by Christopher Nolan:");
       obj.searchByDirector("Christopher Nolan");
       obj.updateRating("Sholay", 9.0);
       System.out.println("Updated Rating of Inception:");
       obj.displayForward();
       obj.removeMovie("Avatar");
       System.out.println("After Removing Avatar:");
       obj.displayForward();
   }
}
