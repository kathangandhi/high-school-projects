import java.util.*;
import java.text.*;

public class FFB
{
    public static void main(String args[]){
        //String array[] = {"touchdown","touchdown","touchdown"}; 
        //probG(3,array);
        //probH(27.0);
        //probN(100, "Tantalus", 3104500, 5009);
        //String names[][] = {{"Spock", "Sulu"}, {"Sulu", "Uhura"}, {"Spock", "Kirk"}, {"Crusher", "Worf"}, {"Picard", "Worf"}, {"Chekov", "Uhura"}, {"Janeway", "Chakotay"}};
        //probL(names);
        int[][] hand = {{13,26,6,2,9,8,5,5}, {11,26,6,2,9,8,5,5}, {11,26,6,2,9,8,5,8}, {26,13,39,2,9,8,5,7}};
        probK(hand);
    }

    public static void probG(int highlights, String eventOrder[])
    {
        int total = 0;
        int current = 0;
        for(int i = 0; i < highlights; i++){
            if(eventOrder[i].equals("touchdown")){
                current+=7;
                total+=current;
            }
            else if(eventOrder[i].equals("field goal")){
                current+=3;
                total+=current;
            }
            else{
                current+=2;
                total+=current;
            }
        }
        System.out.println("Ensign Redshirt does "+total+" pushups!");
    }

    public static void probH(double volume){
        double cube = Math.cbrt(volume);
        double cylinder = Math.cbrt(4*volume/Math.PI);
        double sphere = Math.cbrt(3*volume/(4*Math.PI));
        double cone = Math.cbrt(12*volume/Math.PI);
        double cylinder2 = cylinder/2;
        double cone2 = cone/2;

        cube = (double)Math.round(cube * 100d) / 100d;
        cylinder = (double)Math.round(cylinder * 100d) / 100d; 
        cylinder2 = (double)Math.round(cylinder2 * 100d) / 100d; 
        sphere = (double)Math.round(sphere * 100d) / 100d; 
        cone = (double)Math.round(cone * 100d) / 100d; 
        cone2 = (double)Math.round(cone2 * 100d) / 100d;

        System.out.println("Case #1");
        System.out.println("Borg Cube: "+cube+"m length, "+cube+"m width, "+cube+"m height");
        System.out.println("Whale Cylinder: "+cylinder+"m height, "+cylinder2+"m radius");
        System.out.println("Tholian Sphere: "+sphere+"m radius");
        System.out.println("Remulak Cone: "+cone+"m height, "+cone2+"m radius");
    }

    public static void probK(int[][] game){
        char[] values = {'0','A','2','3','4','5','6','7','8','9','T','J','Q','K'};

        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[0].length; j++){
                if(game[i][j] <= 13)
                    game[i][j] = values[game[i][j]];
                else if(game[i][j] <=26)   
                    game[i][j] = values[game[i][j]/2];
                else if(game[i][j] <=39)
                    game[i][j] = values[game[i][j]/3];
                else
                    game[i][j] = values[game[i][j]/4];
            }
        }

        for(int i = 0; i < game.length; i++){
            int jacks = 0;
            int queens = 0;
            int kings = 0;
            int twos = 0;
            int sixes = 0;
            int aces = 0;
            boolean kronk = false;
            for(int j = 0; j < game.length; j++){
                if(game[i][j]=='K')
                    kings++;
                else if(game[i][j]=='Q')
                    queens++;
                else if(game[i][j]=='J')
                    jacks++;
                else if(game[i][j]=='A')
                    aces++;
                else if(game[i][j]=='2')
                    twos++;
                else if(game[i][j]=='6')
                    sixes++;
                if(j==game.length-1){
                    if(game[i][j]=='K'||game[i][j]=='Q'||game[i][j]=='J'||game[i][j]=='A'||game[i][j]=='2'||game[i][j]=='4'||game[i][j]=='6'||game[i][j]=='8')
                        kronk = true;
                }    
            }
            
            if(kronk)
                System.out.println("KRONK! Scotty beams us all");
            else if(kings==1&&queens==2&&jacks==1&&twos==1&&sixes==1&&aces==2)
                System.out.println("Royal Fizzbin");
            else if(kings==3||queens==3||jacks==3)
                System.out.println("Disqualified");
            else if(kings==2||queens==2||jacks==2)
                System.out.println("Half-Fizzbin");   
                }
        }

        public static void probL(String names[][]){
        int count = 0;
        String[] groups = new String[100];

        groups[0] = names[0][0]+" "+names[0][1];
        for(int i = 1; i < names.length; i++){
            if(groups[count].contains(names[i][0]))
                groups[count] += " "+names[i][1];
            else if(groups[count].contains(names[i][1]))
                groups[count] += " "+names[i][0];
            else{
                count++;
                groups[count] = groups[count-1];
                groups[count] += " "+names[i][0]+" "+names[i][1];
            }   
        }
        System.out.println(count+1); 
    }

    public static void probN(int objMass, String planetName, int radius, int density){
        double gravity = 4.0/3.0 * Math.PI * radius * density * objMass * 6.67 * Math.pow(10,-11);
        gravity = Math.round(gravity * 1000.0)/1000.0;
        System.out.println(planetName+": "+gravity);
    }
}
