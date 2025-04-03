import java.util.ArrayList;
import java.util.Scanner;

//this class allows users to manage a library system where they can add, borrow, return, and display books.
public class Library 
{
    private ArrayList<Book> books;
    private Scanner input;

    public Library() 
    {
        //this is a constructor to initialize a library with an empty list of books and a scanner for taking user input.
        books = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void showMenu() 
    {
        //this method prints out the menu options and accepts a choice from the user.
        while (true) 
        {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) 
            {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> displayAvailableBooks();
                case 5 -> {
                    System.out.println("Exiting program...");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() 
    {
        //this is a method to add a new book to the library.
        try 
        {
            System.out.print("Enter book title: ");
            String title = input.nextLine();
            if (title == null || title.trim().isEmpty()) 
            {
                throw new InvalidBookException();
            }
            Book newBook = new Book(title);
            books.add(newBook);
            System.out.println("Book added successfully!");
        } 
        catch (InvalidBookException e) 
        {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private void borrowBook() 
    {
        //this is a method to borrow a book from the library.
        System.out.print("Enter book title to borrow: ");
        String title = input.nextLine();
        
        try
        {
            for (Book book : books) 
            {
                if (book.getTitle().equalsIgnoreCase(title)) 
                {
                    if (book.isBorrowed()) 
                    {
                        throw new BookAlreadyBorrowedException();
                    }
                    book.borrow();
                    System.out.println("You have borrowed: " + title);
                    return;
                }
            }
        }
        catch (BookAlreadyBorrowedException e) 
        {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    private void returnBook() 
    {
        //this is a method to return a borrowed book to the library.
        System.out.print("Enter book title to return: ");
        String title = input.nextLine();
        
        for (Book book : books) 
        {
            if (book.getTitle().equalsIgnoreCase(title) && book.isBorrowed()) 
            {
                book.returnBook();
                System.out.println("You have returned: " + title);
            }
        }
        System.out.println("Book not found or wasn't borrowed.");
    }

    private void displayAvailableBooks() 
    {
        //this is a method to display all available books in the library.
        System.out.println("Available Books:");
        boolean available = false;
        
        for (Book book : books) 
        {
            if (!book.isBorrowed()) 
            {
                System.out.println("- " + book.getTitle());
                available = true;
            }
        }
        
        if (!available) 
        {
            System.out.println("No books available at the moment.");
        }
    }

    public class InvalidBookException extends Exception 
    {
        //custom exception class for invalid book inputs.
        public InvalidBookException() 
        {
            super("Invalid book title. Please try again.");
        }
    }

    public class BookAlreadyBorrowedException extends Exception 
    {
        //custom exception class for when a book is already borrowed.
        public BookAlreadyBorrowedException() 
        {
            super("This book is already borrowed.");
        }
    }
    
    public static void main(String[] args) 
    {
        //main method to run the library system.
        Library library = new Library();
        library.showMenu();
    }
}
