import java.util.*;
/**
 * The class that stores a list of Books
 */
public class Bookstore{
    ArrayList<Book> inventory;//contains all the Books

    /** Default constructor to initialise <code>inventory</code> */
    public Bookstore(){
        inventory = new ArrayList<Book>();
    }

    //setter method
    public void addBook(Book b){
        inventory.add(b);
    }

    //getter method
    public int numBooks(){
        return inventory.size();
    }

    /** 
     * Searches and return the <code>Book</code> at an index
     * @param index the index of the wanted <code>Book</code>
     */
    public Book getBook(int index){
        if(index >= 0 && index < numBooks())
            return inventory.get(index);
        else
            return null;
    }
}
