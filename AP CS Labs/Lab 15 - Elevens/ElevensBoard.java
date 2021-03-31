import java.util.*;
public class ElevensBoard extends Board{
    public ElevensBoard(){
        super(9,new int[] {1,2,3,4,5,6,7,8,9,10,0,0,0});
    }

    public boolean anotherPlayIsPossible(){
        if(containsPairSum(cardIndexes())||containsExc(cardIndexes()))
            return true;
        return false;
    }

    public boolean isLegal(List<Integer> selectedCards){
        if(containsPairSum(selectedCards) || containsExc(selectedCards)){
            return true;
        }

        return false;
    }

    public boolean containsPairSum(List<Integer> selectedCards) {
        int[] cardVals = new int[selectedCards.size()];
        for(int i = 0; i < selectedCards.size(); i++){
            cardVals[i] = cardAt(selectedCards.get(i)).pointValue();
        }

        for(int fixCard = 0; fixCard < selectedCards.size(); fixCard++){
            for(int var = fixCard; var < selectedCards.size(); var++){
                if(cardVals[fixCard] + cardVals[var] == 11)
                    return true;
            }
        }
        return false;
    }

    public boolean containsExc(List<Integer> selectedCards){
        String[] cardRanks = new String[selectedCards.size()];
        boolean[] JQK = new boolean[3];
        for(int i = 0; i < selectedCards.size(); i++){
            cardRanks[i] = cardAt(selectedCards.get(i)).rank();
            if(cardRanks[i].equals("jack"))
                JQK[0] = true;
            if(cardRanks[i].equals("queen"))
                JQK[1] = true;
            if(cardRanks[i].equals("king"))
                JQK[2] = true;
        }

        return JQK[0]==true&&JQK[1]==true&&JQK[2]==true;
    }
}
