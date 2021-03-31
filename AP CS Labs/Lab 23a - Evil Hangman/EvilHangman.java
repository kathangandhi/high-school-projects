import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EvilHangman{
    private boolean debug;
    private Scanner in;
    private List<String> wordList;
    private int wordLength;
    private int remainingGuesses;
    private String solution;
    private String guessedLetters;

    /**
     * Construct an EvilHangman object.
     * @param fileName the name of the file that contains the word list.
     * @param debug indicates if the size of the remaining word list
     *        should be included in the toString result.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    public EvilHangman(String fileName, boolean debug)
    throws FileNotFoundException{
        this.debug = debug;
        this.in = new Scanner(System.in);

        inputWords(fileName);

        System.out.print("Number of guesses? ");
        this.remainingGuesses = in.nextInt();
        System.out.println();

        this.guessedLetters = new String();

        this.solution = "";
        for(int i = 0; i < wordLength; i++){
            this.solution += "-";
        }
    }

    /**
     * Plays one the game.  The user guesses letters until either
     * they guess the word, or they run out of guesses.
     * Game status is printed each turn and winning / losing
     * information is printed at the conclusion of the game.
     */
    public void playGame(){
        Partition sol = new Partition(solution);
        String savedSolution = new String();

        while(solution.contains("-") && remainingGuesses > 0){
            System.out.println(this);
            String letter = inputLetter();
            System.out.println();
            guessedLetters += letter;
            List<Partition> partsList = this.getPartitionList(letter);
            removeSmallerPartitions(partsList);
            wordList = getWordsFromOptimalPartition(partsList);
            substitute(wordList.get(0),letter);
            remainingGuesses--;
        }

        if(remainingGuesses > 0)
            System.out.println("You win, congratulations!");
        else
            System.out.println("You are a loser! :(");

        int index = (int) Math.random()*wordList.size();
        System.out.println("The word was \""+wordList.get(index)+"\"");
    }

    /**
     * Creates and returns a status string that indicates the
     * state of the game.
     * @return the game status string.
     */
    public String toString(){
        String toReturn = new String();

        if(!debug){
            toReturn = "Remaining guesses: "+this.remainingGuesses+"\n"+
            "Guessed letters: "+this.guessedLetters+"\n"+
            "Solution: "+this.solution+"\n";
        }
        else{
            toReturn = "Remaining guesses: "+this.remainingGuesses+"\n"+
            "Guessed letters: "+this.guessedLetters+"\n"+
            "Solution: "+this.solution+"\n"+
            "Remaining words: "+this.wordList.size()+"\n";
        }

        return toReturn;
    }

    ////////// PRIVATE HELPER METHODS //////////
    /**
     * Helper method for the constructor:
     * Inputs the word length from the user, reads in the words from
     * the fileName file, and initializes the wordList instance variable
     * with the words of the correct length.  This method loops until
     * a valid word length is entered.
     * @param fineName the name of the file that contains the word list.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    private void inputWords(String fileName) throws FileNotFoundException{
        this.wordList = new ArrayList<String>();

        while(this.wordList.isEmpty()){
            System.out.print("Word length? ");
            this.wordLength = in.nextInt();

            Scanner file = new Scanner(new File(fileName));
            while(file.hasNext()){
                String word = file.next();

                if(word.length() == wordLength)
                    this.wordList.add(word);
            }

            if(this.wordList.isEmpty())
                System.out.println("There are no words with "
                    +this.wordLength+" letters.");
        }
    }

    /**
     * Helper method for playGame:
     * Inputs a one-letter string from the user.
     * Loops until the string is a one-character character in the range
     * a-z or A-Z.
     * @return the single-letter string converted to upper-case.
     */
    private String inputLetter(){
        boolean run = true;
        String input = new String();

        while(run){
            System.out.print("Next letter? ");
            input = in.next().toUpperCase();

            if(input.length() == 1 && Character.isLetter(input.charAt(0)))
                run = false;
            else
                System.out.println("Invalid input!");
        }

        return input;
    }

    /**
     * Helper method for getPartitionList:
     * Uses word and letter to create a pattern.  The pattern string
     * has the same number of letter as word.  If a character in
     * word is the same as letter, the pattern is letter; Otherwise
     * it's "-".
     * @param word the word used to create the pattern
     * @param letter the letter used to create the pattern
     * @return the pattern
     */
    private String getPattern(String word, String letter)
    {
        String newPattern = new String();

        for(int i = 0; i < word.length(); i++){
            if(word.substring(i,i+1).equals(letter))
                newPattern += letter;
            else
                newPattern += "-";
        }

        return newPattern;
    }

    /**
     * Helper method for playGame:
     * Partitions each string in wordList based on their patterns.
     * @param letter the letter used to find the pattern for
     *        each word in wordList.
     * @return the list of partitions.
     */
    private List<Partition> getPartitionList(String letter)
    {
        ArrayList<Partition> partList = new ArrayList<Partition>();

        for(int i = 0; i < wordList.size(); i++){
            String pattern = this.getPattern(wordList.get(i),letter);
            String word = wordList.get(i);
            boolean check = false;

            for(int j = 0; j < partList.size(); j++){
                Partition curr = partList.get(j);
                if(curr.addIfMatches(pattern,word))
                    check = true;
                else
                    curr.addIfMatches(pattern,word);
            }

            if(!check)
                partList.add(new Partition(pattern,word));   
        }

        return partList;
    }

    /**
     * Helper method for playGame:
     * Removes all but the largest (most words) partitions from partitions.
     * @param partitions the list of partitions.
     *        Precondition: partitions.size() > 0
     * Postcondition: partitions
     * 1) contains all of the partitions with the most words.
     * 2) does not contain any of the partitions with fewer than the most words.
     */
    private void removeSmallerPartitions(List<Partition> partitions){
        int max = Integer.MIN_VALUE;
        int index = 0;

        for(int i = 0; i < partitions.size(); i++){
            Partition curr = partitions.get(i);
            int size = curr.getWords().size();

            if(size > max){
                max = size;
                index = i;
            }
        }

        Partition big = partitions.get(index);
        partitions.clear();
        partitions.add(big);
    }

    /**
     * Helper method for playGame:
     * Returns the words from one of the optimal partitions,
     *    that is a partition with the most dashes in its pattern.
     * @param partitions the list of partitions.
     * @return the optimal partition.
     */
    private List<String> getWordsFromOptimalPartition(List<Partition> partitions){
        int index = 0;
        for(int i = 0; i < partitions.size(); i++){
            int maxDashCount = Integer.MIN_VALUE;

            if(partitions.get(i).getPatternDashCount() > maxDashCount){
                maxDashCount = partitions.get(i).getPatternDashCount();
                index = i;
            }
        }

        return partitions.get(index).getWords();
    }

    /**
     * Helper method for playGame:
     * Creates a new string for solution.  If the ith letter of
     * found equals letter, then the ith letter of solution is
     * changed to letter; Otherwise it is unchanged.
     * @param found the string to check for occurances of letter.
     * @param letter the letter to check for in found.
     */
    private void substitute(String found, String letter){
        for(int i = 0; i < found.length(); i++){
            if(found.substring(i,i+1).equals(letter))
                solution = solution.substring(0,i)
                +letter
                +solution.substring(i+1,solution.length());
        }
    }
}
