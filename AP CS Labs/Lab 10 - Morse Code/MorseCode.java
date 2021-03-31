import java.util.*;
import java.io.*;
public class MorseCode{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789 "; 
    private final String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "|"}; 
    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;

    public MorseCode() {
        toText = new HashMap<String, String>();
        toCode = new HashMap<String, String>();

        for(int i = 0; i < alphabet.length(); i++){
            toText.put(morse[i], alphabet.substring(i,i+1));
            //System.out.println(toText.get(morse[i]));
            toCode.put(alphabet.substring(i,i+1), morse[i]);
            //System.out.println(toCode.get(alphabet.substring(i,i+1)));
        }
    }

    public String encode(String s){
        String toReturn = "";
        
        for(int i = 0; i < s.length(); i++){
            String letter = s.substring(i,i+1);
            for(int j = 0; j < toCode.size(); j++){
                if(toCode.containsKey(letter)){
                    toReturn += toCode.get(letter)+" ";
                    break;
                }
            }
        }
        
        return toReturn;
    }

    public String decode(String s){ 
        Scanner in = new Scanner(s);
        String toReturn = "";
        
        while(in.hasNext()){
            String sign = in.next(); 
            for(int j = 0; j < toText.size(); j++){
                if(toText.containsKey(sign)){
                    toReturn += toText.get(sign);
                    break;
                }
            }
        }
        
        return toReturn;
    }
}
