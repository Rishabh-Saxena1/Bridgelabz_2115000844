class Book{
    String title;
    int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo(){
        System.out.println("Title of the book is: "+ title + " and publication year is: " + publicationYear);
    }
}
class Author extends Book{
    String name;
    String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title,publicationYear);
        this.name = name;
        this.bio = bio;
    }
    public void displayInfo(){
        System.out.println("Details of book with author's details");
        super.displayInfo();
        System.out.println("Author's name: "+ name + " and Author's bio: " + bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Author au = new Author("Harry Potter", 2001, "J.K.Rowling", "This novel is full of fiction");
        au.displayInfo();
    }
}
