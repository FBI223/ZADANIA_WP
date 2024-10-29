
import java.util.List;
import java.util.ArrayList;


public class fasada_ksiegarni {

}


class Library
{
    String location;
    Librarian librarian;


}


class Librarian {
    String name;
    public List<Book> books = new  ArrayList<>();




}

class User {
    String name;
    String library_location;
    List<Book> books_borrowed = new  ArrayList<>();

    User( Library library, String name  )
    {
        this.library_location = library.location ;
        this.name = name;
    }

    void borrowBook(Book book) {
        if (!book.is_rented) {  // Sprawdzamy, czy książka nie jest wypożyczona
            books_borrowed.add(book);  // Dodajemy odniesienie do tej książki
            book.is_rented = true;  // Oznaczamy książkę jako wypożyczoną
            book.borrower = this;
        }
    }


    void givebackBook(Book book) {
        if (book.is_rented) {  // Sprawdzamy, czy książka nie jest wypożyczona
            books_borrowed.remove(book);  // Dodajemy odniesienie do tej książki
            book.is_rented = false;  // Oznaczamy książkę jako wypożyczoną
            book.borrower = null;
        }
    }
}



class Book{
    User borrower;
    boolean is_rented;
    int book_id;
    String book_name;
    String book_author;
    String library_location;
    Library book_admin;



}

