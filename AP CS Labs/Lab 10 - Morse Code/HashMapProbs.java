import java.util.*;
import java.io.*;
public class HashMapProbs{
    //1
    public static void main(String args[]) throws IOException{
        /*
        //2
        HashMap<String, String> animalSounds = new HashMap<>();

        animalSounds.put("Dog","Woof");
        animalSounds.put("Cat", "Meow");
        animalSounds.put("Bird", "Tweet");
        animalSounds.put("Humans", "Laugh");

        //3
        System.out.println("Enter search: ");
        Scanner in = new Scanner(System.in);
        String key = in.next();
        if(animalSounds.get(key)!=null)
        System.out.println(animalSounds.get(key));
        else
        System.out.println("null");
        System.out.println();

        //4
        System.out.println(animalSounds.size());
        System.out.println();

        //5
        System.out.print("Enter animal: ");
        String newAnimal = in.next();
        System.out.print("Enter sound: ");
        String newSound = in.next();
        animalSounds.put(newAnimal, newSound);
        System.out.println(animalSounds.get(newAnimal));

        //7
        HashMap<String, String> test = new HashMap<>();
        test.put("b", "dirt"); test.put("a", "candy");
        System.out.println(mapBully(test));

        //8
        HashMap<String, String> test = new HashMap<>();
        test.put("b", "dirt"); test.put("a", "candy"); test.put("c", "chip");
        System.out.println(mapShare(test));
         */

        //9
        WordCloud(new File("dream.txt"));
    }

    //7
    public static HashMap<String, String> mapBully(HashMap<String, String> map){
        String aValue = map.get("a");
        map.put("a","");
        map.put("b", aValue);

        return map;
    }

    //8
    public static HashMap<String, String> mapShare(HashMap<String, String> map){
        map.remove("c");
        String aValue = map.get("a");
        map.put("b",aValue);
        return map;
    }

    //9
    public static void WordCloud(File f) throws IOException{
        Scanner word = new Scanner(f);
        HashMap<String, Integer> map = new HashMap<>();

        while(word.hasNext()){
            String test = word.next().toLowerCase();
            if(map.containsKey(test)){
                int value = map.get(test);
                map.put(test, value+1);   
            }
            else{
                map.put(test, 1);
            }
        }

        int mostHits = Collections.max(map.values());
        String mostWord = "";
        
        for(String key: map.keySet()){
            if(map.get(key) == mostHits){
                mostWord = key;
            }
        } 

        System.out.println("Most frequent word: \""+mostWord+"\" at "+mostHits);
    }
}
