import java.util.*;

public class MorseConvert{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789 "; 
    private final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|"}; 
    private HashMap<String, String> toText; 
    private HashMap<String, String> toCode;
    
    public static void main(String args[]){
        MorseConvert m = new MorseConvert();
        System.out.println(m.encode("hello"));
    }
    
    public MorseConvert(){
        toText = new HashMap<>();
        toCode = new HashMap<>();
        
        for(int i = 0; i < alphabet.length(); i++){
            toText.put(alphabet.substring(i,i+1), morse[i]);
            toText.put(morse[i], alphabet.substring(i,i+1));
        }
    }
    
    public String encode(String s){
        return "";
    }
    
    public String decode(){
        return "";
    }
}
