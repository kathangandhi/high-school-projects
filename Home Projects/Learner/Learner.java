import java.util.*;
import java.io.DataInputStream;
public class Learner implements Comparable{
    private int size;//instance variable

    public static void main(String args[]){
        /*
        //Printf statements
        int size = 271;
        System.out.printf("%d%n",size);//2 parameters - formatted string, variables
        //%c = char
        //%d = int
        //%e = scientific notation
        //%f = decimal
        //%n = new line
        //%s = String

        //You can insert formatting stuff between % and letter
        //examples
        double num = 22.415;
        System.out.printf("%.2f%n",num);//2 decimal places rounding
        System.out.printf("%2f%n",num);//2 spaces left
        System.out.printf("|%-10f|%n",num);//left indent
        System.out.printf("%,+f%n",num);//thousands commas and + sign
        System.out.printf("%.5s","Hello World");//chop after given no. of characters

        //Bitwise Operators

        int a = 10; //0001010
        int b = 20; //0010100

        System.out.println(a&b);//0000000 = 0 [and]
        System.out.println(a|b);//0011110 = 30 [or]
        System.out.println(a^b);//0011110 = 30 [xor - one not both]
        System.out.println(~a);// -11 [bitwise compliment - +1 and (-)]
        System.out.println(a >> 2);//0000010 = 2 [shift binary right]
        System.out.println(a >>> 2);//0000010 = 2 [same as above & zeros added]
        System.out.println(a << 2);//00101000 = 40 [shift binary left]

        // can also be compounded like += or *=

        //examples
        a >>= 2;//a = a >> 2;
        System.out.println(a);

        a = 10;//reset a's value
        b |= a;//b = b|a;
        System.out.println(b);
         */

        //New boolean operators[non-short circuit]
        /*
        //| = ||, but | checks both conditions while || continues if 1 is true
        String var = null;
        if(var==null||var.charAt(0)=='b')//1st condition satisfied
        System.out.println("skipped");

        if(var==null|var.charAt(0)=='b')//both conditions checked
        System.out.println("skipped");

        //2nd if statement gives NullPointerException cuz var is null
        //charAt(0) cannot be called

        //Same thing for & vs &&
        //^ is the xor operator - this or that, not both
        String s = "kat";
        if(s.substring(0,3).equals("kat")^s.length()==3)//both true
        System.out.println("XOR satisfied");
        //no output as both are true

        //Collections.sort() example
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10); arr.add(3); arr.add(12);//arr now has [10,3,12]

        Collections.sort(arr);//sorts arr
        for(Integer i: arr)//for each i in arr
        System.out.println(i);

        //compareTo(Object obj) implementation
        Learner l1 = new Learner(5);
        Learner l2 = new Learner(10); 
        System.out.println(l1.compareTo(l2));//returns -1 as l1's size < l2's size 

        //Pattern[search] class & Matcher[input string] example
        Scanner in = new Scanner(System.in);

        System.out.println("Enter regex: ");
        Pattern pattern = Pattern.compile(in.nextLine());//pattern object constructor

        System.out.println("Enter input: ");
        Matcher matcher = pattern.matcher(in.nextLine());//matcher object constructor
        if(matcher.find()) {
        System.out.printf("I found the text"+" \"%s\" starting at "+
        "index %d and ending at index %d.%n",matcher.group(),matcher.start(),
        matcher.end());
        }
        else{
        System.out.printf("No match found %n");
        }

        //every \[letter] is special and the capital version is non-...
        //\d = digit[0-9]
        //\s = whitespace char
        //\w = word char
        //<([{\^-=$!|]})?*+.> = any char

        //[abc] = a/b/c
        //[^abc] = xor (a/b/c)
        //[a-zA-z] = union a-z and A-Z
        //***only applicable for regex***

        //ALL COLLECTIONS
        //addAll(Collection) is union of collections
        //containsAll(Collection) checks for subsetness
        //retainAll(Collection) is intersection of collections
        //removeAll(Collection) is difference of collections
        //add(element) adds an element to collection
        //remove(element) or remove() removes element from collection [if it exists]

        //a tree map is a hashmap ordered by keys
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(2,"hello"); map.put(1,"hello"); map.put(3,"bye");
        System.out.println(map.toString());//ordered in ascending order of ints

        //a hashtable[allows nulls, is unsynchronised] is roughly similar to hashmap
        //linkedhashmap preserves order of insertion

        //a set is like mathematical set[all same object types, no duplicates]
        //HashSet is best well-rounded
        //TreeSet is ascending order

        //HashSet example
        Set<Integer> s = new HashSet<Integer>(); 
        Scanner in = new Scanner(System.in);
        int num = Integer.MIN_VALUE;
        //variables initialised

        System.out.println("Enter nums(0 to stop)");
        while(num!=0){//loop to parse all input integers
        num = in.nextInt();
        s.add(num);
        }

        System.out.println(s.toString());

        //TreeSet example
        Set<String> newSet = new TreeSet<String>();
        newSet.add("hello"); newSet.add("bye"); newSet.add("fine");

        System.out.println(newSet.toString());//prints elements in alphabetical order

        //queue holds elements before processing
        //element()/peek() returns head of queue
        //poll() = remove() but returns null[on failure]
        //offer() = add() but returns false[on failure]
        //PriorityQueue has natural ordering and accepts no nulls
        //LinkedList maintains insertion order and accepts nulls
        //LinkedList is like an ArrayList - it's faster to manipulate, slower to store

        //PriorityQueue example
        Queue<Integer> qDemo = new PriorityQueue<Integer>();
        qDemo.add(10); qDemo.add(2); qDemo.add(5); qDemo.remove();
        System.out.println(qDemo.toString());//prints ordered queue [5,10]
        System.out.println(qDemo.element());//prints 5 as it is the head

        //LinkedList example
        Queue<Integer> qD = new LinkedList<Integer>();
        qD.add(10); qD.add(2); qD.add(5); qD.remove();
        System.out.println(qD.toString());//prints insert order queue [2,5]
        System.out.println(qD.element());//prints 2 as it is the head

        //stack is a reverse queue where the last element in is the top
        //push(element) = add(element)
        //pop() = remove()
        //peek() is the same
        //search(element) returns (distance from top + 1)

        Stack<String> demoS = new Stack<String>();
        demoS.push("bottom"); demoS.push("middle"); demoS.push("top"); 
        System.out.println(demoS.toString());
        demoS.pop();//removes "top"
        System.out.println(demoS.search("middle"));//returns 1 as "middle" is the top

        //binary trees organise data with 1 node and 2 branches:
        //example
        //                1 [root]
        //               / \
        //              2   3 [nodes]
        //             /     \
        //           null    null
        //[parent = 1],[child = 2,3]

        //binary heaps are similar to binary trees but they are ordered ascending/descending
        //used in making arrays/Lists etc.

        //graphs represent relationships between data
        //adjacency matrix = 2d arrays
        //adjacency list = linkedlists

        //recursive example
        System.out.println(Learner.factorial(5));
        System.out.println(Learner.countdown(10));

        //Special parameters in String methods
        String s = "new year";
        s = s.replaceAll("[ea]+","o");
        System.out.println(s);
        //will print now yor as both e and a are replaced; if ea appear - replaced by o
       
        String s = "AP CS rules my subjects"; 
        String[] storage = s.split("[AC]+");
        System.out.println(Arrays.toString(storage));
        */
         
            
    }

    //constructor
    public Learner(int size){
        this.size = size;
    }

    //method where int is returned signifies this Object's relation to parameter Object
    @Override
    public int compareTo(Object obj){
        Learner t = (Learner) obj;//casting the Object
        if(this.size > t.getSize())
            return 1;
        else if(this.size < t.getSize())
            return -1;
        return 0;
    }

    //getter method for size
    public int getSize(){
        return size;
    }

    //recursive copied method
    public static int factorial(int n)
    {
        if (n == 1)
            return 1;
        else
            return n * factorial(n-1);
    }

    //recursive creation
    public static String countdown(int seconds)
    {
        if (seconds == 1)
            return "1";
        else
            return seconds+" "+countdown(seconds-1);
    }
}

