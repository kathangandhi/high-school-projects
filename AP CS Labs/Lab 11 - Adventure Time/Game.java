import java.util.Scanner;
public class Game{
    private Player p1;
    private Scanner console;
    private Item blade;
    private Room cave, batColony, mouth, pass, bridge, volcano, gas, tunnel1, tunnel2, tunnel3, heatMachine, garbagePile, candyMan, jail, subTunnel, street, carCrash, trainCrash, door;
    
    public Game(){
        console = new Scanner(System.in);
        createRooms();
    }
    
    /** Creates Room objects and sets exits to create the game world */
    private void createRooms(){
        //create Items
        blade = new Item("a short,blunt blade","cut bars maybe","knife");
        
        //create Rooms
        cave = new Room("A hollow, echoing cave",null);       
        batColony = new Room("A bat colony where danger lies",null);        
        mouth = new Room("Mouth of cave with shimmer of light",null);
        pass = new Room("Eerie silence and darkness",null);
        bridge = new Room("Narrow rock bridge",null);
        volcano = new Room("Volcano breathing lava",null);
        gas = new Room("Toxic nitric oxide",null);
        tunnel1 = new Room("Short tunnel with more light",null);
        tunnel2 = new Room("Stinking, dingy tunnel",blade);
        tunnel3 = new Room("Pleasant tunnel with pleasant fragrance",null);
        heatMachine = new Room("Terribly hot burning machine",null);
        garbagePile = new Room("A dumpyard in the middle of the city",null);;
        candyMan = new Room("A lucrative candy selling man",null);
        jail = new Room("You're chained to a wall in a small prison with other children",null);
        subTunnel = new Room("A sub station with the next train destined to go to Frisco",null);
        street = new Room("A street with cabs",null);
        carCrash = new Room("Car screech",null);
        trainCrash = new Room("Loud hooter",null);
        door = new Room("Door out of jail",null);
        
        //set exits for Rooms
        cave.setExits("north",mouth); 
        cave.setExits("south-east",bridge);
        cave.setExits("west",batColony);
        bridge.setExits("east",pass);
        bridge.setExits("north-west",cave);
        batColony.setExits("down",volcano);
        batColony.setExits("up",gas);
        volcano.setExits("right",tunnel1);
        volcano.setExits("left",tunnel2);
        volcano.setExits("front",tunnel3);
        volcano.setExits("up",batColony);
        tunnel1.setExits("ahead",heatMachine);
        tunnel1.setExits("behind",volcano);
        tunnel2.setExits("ahead",garbagePile);
        tunnel2.setExits("behind",volcano);
        tunnel3.setExits("ahead",candyMan);
        tunnel3.setExits("behind",volcano);
        garbagePile.setExits("left",subTunnel);
        garbagePile.setExits("right",street);
        garbagePile.setExits("behind",tunnel2);
        street.setExits("ahead",carCrash);
        street.setExits("behind",garbagePile);
        subTunnel.setExits("ahead",trainCrash);
        subTunnel.setExits("behind",garbagePile);
        
        //set start place
        p1 = new Player(cave);
    }
    
    private void printWelcome(){
        System.out.println("Welcome to my text-based adventure, noob!");
        System.out.println("Get ready to survive in this cruel world");
        System.out.println("Type 'help' if you need help\n");
        System.out.println("You are here >>> " + p1.getRoom().getDescription());
        System.out.println();
    }
    
    private void printHelp(){
        System.out.println();
        
        System.out.println("You are alone, you are lost.");
        System.out.println("You wander around the surroundings.");
        System.out.println("Your commands are >>> " + Command.getCommandsString());
    }
    
    /** Takes a Command object and attempts to process it as a game command */
    private boolean processCommand(Command command) throws InterruptedException{
        boolean finished = false;

        if(command.isUnknown()){
            System.out.println("I don't know what you mean...");
            return finished;
        }              String commandWord = command.getCommandWord();
        if(commandWord.equals("help"))
            printHelp();
        else if(commandWord.equals("go"))
            finished = goRoom(command);
        else if(commandWord.equals("quit"))
            finished = quit(command); 
        else if(commandWord.equals("take"))
            takeItem(command);
        
        return finished;
    }
    
    /** Attempts to move the player to another Room based on their Command */
    private boolean goRoom(Command command) throws InterruptedException{
        if(command.getSecondWord()==null){
            System.out.println("Go where?");
            return false;
        }
        
        String direction = command.getSecondWord();
        Room nextRoom = p1.getRoom().getExit(direction);
        
        if(nextRoom!=null){
            p1.setRoom(nextRoom);
            System.out.println("You are here >>> "+ p1.getRoom().getDescription());
        }
        else{
            System.out.println("There is no door!");
            return false;
        }
        
        System.out.println();
        if(p1.getRoom().equals(mouth)){
            System.out.println("You didn't notice the quicksand on the way and died");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(bridge)){
            System.out.println("Things get crazy from here");
        }
        else if(p1.getRoom().equals(pass)){
            System.out.println("Your laziness takes you to a cliff and you slip");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(gas)){
            System.out.println("The gas makes you faint and fall");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(heatMachine)){
            System.out.println("The heat melts you");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(candyMan)){
            System.out.println("You buy poisonous candy and the candy man kidnaps you");
            p1.setRoom(jail);
            System.out.println(p1.getRoom().getDescription());
            if(p1.inventoryHas(blade))
                jail.setExits("out",door);
            else{
                System.out.println("I guess you are stuck here");
                System.out.println("Go back to the volcano");
                p1.setRoom(volcano);
            }
                
        }
        else if(p1.getRoom().equals(carCrash)){
            System.out.println("A car crash led to your fatal accident");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(trainCrash)){
            System.out.println("You succumb to the horse power of the train");
            System.out.println("Try again");
            return true;
        }
        else if(p1.getRoom().equals(door)){
            System.out.println("The police found you and you meet your parents");
            System.out.println("GG! Well played! You aren't a noob after all");
            Thread.sleep(2000);
            return true;
        }
        return false;
    }
    
    /** Returns true if the user is wanting to quit */
    private boolean quit(Command command){
        if(command.getSecondWord() != null){
            System.out.println();
            System.out.println("Quit what?");
            return false;
        }
        else{
            System.out.println();    
            System.out.println("Thanks for playing, goodbye.");
            return true;
        }
    }
    
    /** Attempts to take an Item based on their Command */
    private void takeItem(Command command){
        if(command.getSecondWord()==null){
            System.out.println("Take what?");
            return;
        }
        
        String chant = command.getSecondWord();
        Room now = p1.getRoom();
        
        if(now.getItem()!=null){
            if(chant.equals(now.getItem().getChant())){
                p1.addItem(now.getItem());
                System.out.println("You have obtained the requested item");
            }
            else
                System.out.println("You must invoke right item name");
        }
        else{
            System.out.println("There is no item!");
        }
    }
    
    /** This method starts the game, continuing until the user wants to quit */
    public void play() throws InterruptedException{
        printWelcome();
        boolean finished = false;
        
        do{
            System.out.println(p1.getRoom().getExitString());
            System.out.println();
            System.out.println(">>> ");
            
            String line = console.nextLine();
            Scanner tokenizer = new Scanner(line);
            String command = null, second = null;
            
            if(tokenizer.hasNext()){
                command = tokenizer.next();
            }
            
            if(tokenizer.hasNext()){
                second = tokenizer.next();
            }
            
            Command instruction = new Command(command, second);
            finished = processCommand(instruction);
        }while(!finished);
        
        System.out.println("Do you want to play again? [y/n]");
        if(console.next().equals("y")){
            System.out.println("\u000c");
            play();
        }
        else
            System.exit(0);
    }
}
