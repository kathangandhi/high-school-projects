import java.util.*;

public class ArrayListProbs{
    /**
     * Adds <code>num</code> no. of ints within a limit of 0 to <code>limit</code>
     * @param num the number of elements to add
     * @limit the highest value an element can be
     */
    public void makeListAndPrint(int num, int limit){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();

        for(int i = 0; i < num; i++){
            int element = rand.nextInt(limit);
            list.add(element);
        }

        System.out.println(list);
    }

    /**
     * Finds the lowest value in the provided ArrayList <code>list</code>
     * @param list the ArrayList provided
     */
    public ArrayList<Integer> minToFront(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i)<min)
                min = list.get(i);
        }
        list.add(0,min);

        return list;
    }

    /**
     * Add one to each element in the provided ArrayList <code>list</code>
     * @param list the ArrayList provided
     */
    public ArrayList<Integer> addOne(ArrayList<Integer> list){
        int loop = list.size();

        for(int i = 0; i < loop; i++){
            list.set(i,list.get(i)+1);
        }

        return list;
    }

    /**
     * Remove duplicate elements in the provided ArrayList <code>list</code>
     * @param list the ArrayList provided
     */
    public ArrayList<String> removeDupes(ArrayList<String> list){
        int size = list.size();
        String s1, s2 = "";

        for(int i = 0; i < size-1; i++){
            s1 = list.get(i);
            s2 = list.get(i+1);
            if(s1.equals(s2)){
                list.remove(s2);
                size--;
            }
        }

        return list;
    }

    /**
     * Swaps elements in pairs in the provided ArrayList <code>list</code>
     * @param list the ArrayList provided
     */
    public ArrayList<Integer> swapPairs(ArrayList<Integer> list){
        int indexShift, num1, num2, temp = 0;
        int size = list.size();

        for(int i = 0; i < size-1; i+=2){
            num1 = list.get(i);
            num2 = list.get(i+1);

            temp = num1;
            num1 = num2;
            num2 = temp;

            list.remove(i);
            list.remove(i);
            list.add(i,num2);
            list.add(i,num1);
        }

        return list;
    }

    /**
     * Remove String elements with certain length
     * @param list the ArrayList provided
     * @param n the length provided
     */
    public ArrayList<String> removeLenN(ArrayList<String> list, int n){
        int size = list.size();

        for(int i = 0; i < size; i++){
            String s = list.get(i);
            if(s.length()==n){
                list.remove(s);
                size--;
            }
        }

        return list;
    }

    /**
     * Finds person with lowest IQ and returns his/her index in <code>list</code>
     * @param list the ArrayList provided
     * @return the index of the dumbest person (lowest IQ)
     */
    public int dumbestPerson(ArrayList<Person> list){
        int index = 0;
        int IQScale = Integer.MAX_VALUE;
        int size = list.size();

        for(int i = 0; i < size; i++){
            Person p = list.get(i);
            if(p.getIQ() < IQScale){
                index = i;
                IQScale = p.getIQ();
            }
        }

        return index;
    }

    /**
     * Finds <code>Book</code> with highest price
     * @param list the ArrayList provided
     * @return the <code>Book</code> reference for 
     */
    public Book highestPricedBook(ArrayList<Book> list){
        int index = 0;
        double highPrice = Double.MIN_VALUE;
        Book ans = new Book("", "", 0.0);
        int size = list.size();

        for(int i = 0; i < size; i++){
            Book b = list.get(i);
            if(b.getPrice() > highPrice){
                index = i;
                highPrice = b.getPrice();
                ans = b;
            }
        }

        return ans;
    }

    public ArrayList<Book> banBook(ArrayList<Book> list, Book book){
        int index = 0;
        int size = list.size();

        for(int i = 0; i < size; i++){
            Book b = list.get(i);
            if(b.getTitle().equals(book.getTitle())){
                list.remove(i);
                size--;
            }
        }

        return list;
    }

    public double bookstoreValue(Bookstore store){
        double total = 0;
        int size = store.numBooks();

        for(int i = 0; i < size; i++){
            total += store.getBook(i).getPrice();
        }

        return total;
    }
}
