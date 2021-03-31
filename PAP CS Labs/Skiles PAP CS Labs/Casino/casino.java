 

public class casino
{
    public static void main(String args[])
    {
        showBanner();
    }
    
    public static void showBanner()
    {
        System.out.println("*****************************");
        System.out.println("*         CS Casino         *");
        System.out.println("*****************************");
        
       /* //Start of Section 1
        slotMachine testSlot = new slotMachine();
        testSlot.play(25);
        */
             
        //Start of Section 2
        slotMachine slot1 = new slotMachine();
        slotMachine slot2 = new slotMachine();
        slotMachine slot3 = new slotMachine();
        slotMachine slot4 = new slotMachine();
        
        player john = new player("John", 100);
        player sam = new player("Sam", 100);
        player marty = new player("Marty", 100);
        player mary = new player("Mary", 100);
        
        for(int round = 0; round < 10; round++)
        {
        System.out.println();
        System.out.println("John Plays Slot1");
        john.play(slot1);
        System.out.println("John has $"+john.getBank()+ " left");
        
        System.out.println();
        System.out.println("Sam Plays Slot2");
        sam.play(slot2);
        System.out.println("Sam has $"+sam.getBank()+ " left");
        
        System.out.println();
        System.out.println("Marty Plays Slot3");
        marty.play(slot3);
        System.out.println("Marty has $"+marty.getBank()+ " left");
        
        System.out.println();
        System.out.println("Mary Plays Slot4");
        mary.play(slot4);
        System.out.println("Mary has $"+mary.getBank()+ " left");
        } 
        
       //End of Section 2
    }

}