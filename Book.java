public class Book 
{
    private String title;
    private boolean isBorrowed;

    public Book(String title) 
    {
        this.title = title;
        this.isBorrowed = false;
    }

    public String getTitle() 
    {
        //get the title of the book
        return title;
    }

    public boolean isBorrowed() 
    {
        //check if the book is currently borrowed
        return isBorrowed;
    }

    public void borrow() 
    {
        //mark the book as borrowed
        if (!isBorrowed) 
        {
            isBorrowed = true;
        } 
        else 
        {
            System.out.println("This book is already borrowed.");
        }
    }

    public void returnBook() 
    {
        //mark the book as returned
        if (isBorrowed) 
        {
            isBorrowed = false;
        } 
        else 
        {
            System.out.println("This book wasn't borrowed.");
        }
    }

    //toString() for better display
    @Override
    public String toString() 
    {
        return title + " (" + (isBorrowed ? "Borrowed" : "Available") + ")";
    }
}