public class Command 
{
    private static String[] commands = {
        "go", "quit", "help", "take"
    };
    
    private String commandWord;
    private String secondWord;
    
    public Command(String first, String second){
        commandWord = first;
        secondWord = second;
    }
    
    /** Returns true if str is a valid command (exists in the array) */
    public static boolean isCommand(String str){
        for(String word: commands){
            if(str.equals(word))
                return true;
        }
        return false;
    }

    /** Gets all the command words in the array, returns as a String */
    public static String getCommandsString(){
        return "\n"+commands[0]+"\n"+commands[1]+"\n"+commands[2]+"\n"+commands[3];
    }

    /** 
     * An 'unknown' command will have a null commandWord
     * A 'known' command will have a valid command as a commandWord 
     */
    public boolean isUnknown() {
        if(commandWord == null || !isCommand(commandWord))
            return true;
        return false;
    }
    
    @Override
    public String toString(){
        return commandWord + " " + secondWord;
    }
    
    public String getCommandWord() { return commandWord; }
    public String getSecondWord() { return secondWord; }
}
