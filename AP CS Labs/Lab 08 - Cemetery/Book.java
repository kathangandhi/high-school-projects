import java.util.*;

public class Book{
    String title, author;
    double price;
    
    /**
     * The Book contructor that initialises title, author, and price 
     * @param title the title of the <code>Book</code>
     * @param author the author of the <code>Book</code>
     * @param price the price of the <code>Book</code>
     */
    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //getter methods
    public String getTitle(){
        return title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String toString(){
        return title+", by "+author+". Cost: $"+price;
    }
}
