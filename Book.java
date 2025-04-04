public class Book 
{
    private String title;
    private boolean isBorrowed;

    public Book(String title) 
    {
        this.title = title;
        this.isBorrowed = false;
    }

    //this method marks the book as borrowed
    public void borrow() 
    {
        this.isBorrowed = true;
    }

    //this method marks the book as available
    public void returnBook() 
    {
        this.isBorrowed = false;
    }

    //this method returns the book's title
    public String getTitle() 
    {
        return title;
    }

    //this method checks and returns whether the book is borrowed or not
    public boolean isBorrowed() 
    {
        return isBorrowed;
    }

    @Override
    public String toString() 
    {
        return title + " (" + (isBorrowed ? "Borrowed" : "Available") + ")";
    }
}
