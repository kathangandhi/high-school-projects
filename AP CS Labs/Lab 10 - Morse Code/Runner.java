import java.util.*;
public class Runner
{
    public static void main(String args[]){
        MorseCode m = new MorseCode();
        System.out.println("hello world");
        System.out.println(m.encode("hello world"));
        System.out.println(m.decode(m.encode("hello world")));
    }
}
