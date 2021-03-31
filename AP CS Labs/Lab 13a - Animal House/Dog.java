import java.util.*;
public class Dog extends Animal{
    private boolean goodBoy;
    
    public Dog(String name, int birthYear, boolean goodBoy){
        super(name,birthYear);
        this.goodBoy = goodBoy;
    }
    
    public String isGoodBoy(){
        if(goodBoy){
            return "good boy.";
        }
        else{
            return "bad boy.";
        }
    }
    
    @Override
    public String toString(){
        String returner = "";
        returner += super.toString();
        returner += "\nI am a "+this.isGoodBoy();
        return returner;
    }
}
