import java.util.*;
import java.io.*;

/**
this is student code, in particular the solve method
in this lab, it just reads the data and populates the 1D array.
results are displayed for the student by calling myView.updateView()
 */

public class ShelbyModel{
    private int[] monthData;
    private ShelbyView view;
    private String fileName;

    public ShelbyModel(String file, ShelbyView myView){
        view = myView;
        fileName = file;
        monthData = new int[12];
    }

    public void solve() throws FileNotFoundException{
        Scanner input = new Scanner(new File(fileName));
        input.nextLine();
        input.nextLine();

        while(input.hasNextLine()){
            String date = input.next();
            boolean loop = true;

            while(loop){
                if(date.length() > 6){
                    if( date.substring(date.length()-4,date.length()).equals("1792") || 
                        date.substring(date.length()-4,date.length()).equals("1793") ||
                        date.substring(date.length()-4,date.length()).equals("1794") ||
                        date.substring(date.length()-4,date.length()).equals("1795") ||
                        date.substring(date.length()-4,date.length()).equals("1796") ||
                        date.substring(date.length()-4,date.length()).equals("1797") ||
                        date.substring(date.length()-4,date.length()).equals("1798") ||
                        date.substring(date.length()-4,date.length()).equals("1799") ||
                        date.substring(date.length()-4,date.length()).equals("1800"))
                        {loop = false;}   
                    else{
                        date = input.next();
                        continue;
                    }
                }
                else
                    date = input.next();
            }

            int place = date.indexOf("/")+1;
            String monthString = date.substring(place,place+2);
            int month = Integer.parseInt(monthString);

            switch(month){
                case 1: monthData[0]++;
                break;
                case 2: monthData[1]++;
                break;
                case 3: monthData[2]++;
                break;
                case 4: monthData[3]++;
                break;
                case 5: monthData[4]++;
                break;
                case 6: monthData[5]++;
                break;
                case 7: monthData[6]++;
                break;
                case 8: monthData[7]++;
                break;
                case 9: monthData[8]++;
                break;
                case 10: monthData[9]++;
                break;
                case 11: monthData[10]++;
                break;
                case 12: monthData[11]++;
                break;
            }
        }

        view.updateView(monthData); //don't remove
    }
}
