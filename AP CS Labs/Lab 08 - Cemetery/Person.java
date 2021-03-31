import java.util.*;

public class Person
{
    String name;
    int IQ;

    public Person(String title, int iq){
        name = title;
        IQ = iq;
    }

    public String getName(){
        return name;
    }

    public int getIQ(){
        return IQ;
    }
}

