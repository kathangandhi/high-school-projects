import java.util.*;
public class Information{
    private String name;
    private int age;
    private String birthday;
    
    public Information(String name, int age, String birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        String toReturn = new String();
        toReturn += "Name: "+name;
        toReturn += "\nAge: "+age;
        toReturn += "\nBirthday: "+birthday; 
        return toReturn;
    }
}
