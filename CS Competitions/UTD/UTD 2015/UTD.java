
public class UTD{
    public static void main(String args[]){
        //ProblemH(3);
        //ProblemI(8, 7); 
        //ProblemJ(3, 4000);
        //ProblemK(5.0, 5.0, 0.5, 9.0);
        //ProblemL(20);
        System.out.print("40 ");
        ProblemM("40");
    }

    public static void ProblemH(int input){
        System.out.print(input+" ");
        while(input>1){
            if(input%2==0){
                input = (int)Math.sqrt(input);
            }
            else{
                input = (int)Math.pow(Math.sqrt(input),3);
            }
            System.out.print(input+" ");
        }
    }

    public static void ProblemI(int pages, int pageNo){
        int sheets = pages/4;
        int fCount = 1;
        int bCount = pages;
        int it;
        for(it = 0; it < sheets; it++){
            if(pageNo==bCount||pageNo==bCount-1||pageNo==fCount||pageNo==fCount+1){
                break;
            }
            else{
                fCount+=2;
                bCount-=2;
            }
        }
        System.out.println("Page "+pageNo+" is on sheet "+(it+1));
    }

    public static void ProblemJ(int numerator, int denominator){
        int bottom = denominator;
        int whole = numerator/denominator;
        int top = numerator - (whole*denominator);
        System.out.println(whole+" "+top+" / "+bottom);
    }

    public static void ProblemK(double centerX, double centerY, double shotX, double shotY){
        double distance = Math.sqrt(Math.abs(centerX-shotX)*Math.abs(centerX-shotX) + Math.abs(centerY-shotY)*Math.abs(centerY-shotY));
        if(distance < 3)
            System.out.println("50");
        else if(distance < 6)
            System.out.println("20");
        else if(distance < 9)
            System.out.println("10");
        else
            System.out.println("Miss");
    }

    public static void ProblemL(int amount){
        int joe = 0;
        int jane = 0;
        String who = null;
        int count = 1;
        while(amount>0){
            if(count<amount){
                joe+=count;
                amount-=count;
                count++;
            }
            else{
                who = "Jane";
                break;
            }
            if(count<amount){
                jane+=count;
                amount-=count;
                count++;
            }
            else{
                who = "Joe";
                break;
            }
        }

        if(who.equals("Joe")){
            jane+=amount;
        }
        else if(who.equals("Jane")){
            joe+=amount;
        }

        System.out.println(joe+" "+jane);
    }

    public static void ProblemM(String number){
        int places[] = new int[number.length()];
        int product = 1;

        for(int i = 0; i < places.length; i++){
            places[i] = Integer.parseInt(number.substring(i,i+1));
            product *= places[i];
        }

        
        if(product<10){
            System.out.print(product+" ");
        }
        else{
            System.out.print(product+" ");
            ProblemM(Integer.toString(product));
        }
    }
}