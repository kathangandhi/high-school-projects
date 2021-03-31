import java.util.*;
public class House{
    ArrayList<Animal> animals;
    
    public House(){
        animals = new ArrayList<Animal>();
    }
    
    public void printAnimals(){
        for(Animal a: animals){
            cleanHouse();
            System.out.println();
            System.out.println(a.toString());
        }
    }
    
    private void cleanHouse(){
        for(Animal a : animals) { 
            ArrayList<Toy> toys = a.getToys();  
            for (int i = 0; i < toys.size(); i++) {
                if(toys.indexOf(toys.get(i)) == toys.lastIndexOf(toys.get(i))){
                    continue;
                }
                else{
                    toys.remove(toys.get(i));
                }
            }      
        }
    }
    
    public void add(Animal pet){
        animals.add(pet);
    }
}
