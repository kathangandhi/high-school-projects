// Lab10Ast.java


import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class Lab10Ast extends Applet
{
    private static int numDots, speed;
    private static Font countryName;

   
    public void init()
    {
        speed = enterIntGUI("Enter Execution Type: \n 1 = Giant Dots \n 2 = Big Dots \n 3 = Small Dots \n 4 = Tiny Dots\n\nNOTE: Enter 1 when getting lab graded.");
        switch (speed)
        {
            case 1  : numDots =   10000; break;
            case 2  : numDots =  100000; break;
            case 3  : numDots = 1000000; break;
            case 4  : numDots = 5000000; break;
            default : numDots =   10000;
        }
        countryName = new Font("Algerian",Font.BOLD,48);
    }
    
    public void paint(Graphics g)
    {
        numDots =  10000;
        titlePage(g,"Kathan Gandhi","3B");
        //flagOfLibya(g);
        //flagOfMonaco(g);
        //flagOfItaly(g);
        flagOfBelgium(g);
        flagOfIreland(g);
        flagOfGermany(g);
        flagOfAustria(g);
        flagOfMauritius(g);
        flagOfGelderland(g);
        flagOfBerlaar(g);
        flagOfLima(g);
        flagOfDenmark(g);
        flagOfUSA(g);
        flagOfJapan(g);
        flagOfEarth(g);
    }

    public static int enterIntGUI(String prompt)  // Allows GUI keyboard input of an integer in a graphics program.
    {
        String tempString = JOptionPane.showInputDialog(prompt);
        int temp = Integer.parseInt(tempString);
        return temp;
    }

    public static void drawDot(Graphics g, int x, int y)
    {
        switch (speed)
        {
            case 1  : Expo.fillRectangle(g,x-5,y-5,x+5,y+5); break;
            case 2  : Expo.fillRectangle(g,x-2,y-2,x+2,y+2); break;
            case 3  : Expo.fillRectangle(g,x,y,x+1,y+1); break;
            case 4  : Expo.drawPixel(g,x,y); break;
            default : Expo.fillRectangle(g,x-5,y-5,x+5,y+5);
        }
    }

    public static void titlePage(Graphics g, String name, String period)
    {
        Expo.setBackground(g,Expo.blue);
        Expo.setColor(g,Expo.white);
        Expo.fillRectangle(g,100,100,900,550);
        Expo.setColor(g,Expo.red);
        Font title = new Font("Algerian",Font.BOLD,48);
        g.setFont(title);
        g.drawString("Flags of the World",225,240);
        Expo.setColor(g,Expo.blue);
        g.drawString("by: "+name,225,340);
        Expo.setColor(g,Expo.green);
        g.drawString("Period: "+period,225,440);
        Expo.delay(3000);                         // Wait 3 second before showing first flag.
    }

    public static void showName(Graphics g, String name)
    {
        FontMetrics metrics = g.getFontMetrics(countryName);
        int nameWidth = metrics.stringWidth(name);
        int boxWidth  = nameWidth + 20;
        int xName = 950 - nameWidth;
        int xBox  = xName - 10;
        Expo.setColor(g,Expo.white);
        Expo.fillRectangle(g,xBox,50,xBox+boxWidth,120);
        Expo.setColor(g,Expo.black);
        Expo.drawRectangle(g,xBox,50,xBox+boxWidth,120);
        for (int j = 1; j <= 5; j++)
        {
            Expo.drawLine(g,xBox+j,120+j,xBox+boxWidth+j,120+j);
            Expo.drawLine(g,xBox+boxWidth+j,50+j,xBox+boxWidth+j,120+j);
        }
        Expo.drawRectangle(g,xBox+1,51,xBox+boxWidth+1,121);
        g.setFont(countryName);
        g.drawString(name,xName,100);
        Expo.delay(2000);                         // Wait 2 second before showing next flag.
    }

    public static void fiftyStars(Graphics g)     // provided for the USA Flag
    {
        // 30 Stars  (5 rows of 6)
        for (int x = 35; x < 420; x += 70)
            for (int y = 35; y < 350; y += 70)
                Expo.fillStar(g,x,y,20,5);

        // 20 Stars  (4 rows of 5)
        for (int x = 70; x <= 350; x += 70)
            for (int y = 70; y <= 280; y += 70)
                Expo.fillStar(g,x,y,20,5);
    }
    
    public static double distance(int x1, int y1, int x2, int y2) // Used for the circles in the flags of Japan and Earth
    {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));   // distance formula
    }

    public static void flagOfLibya (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            Expo.setColor(g,Expo.green);       // The Libyan flag is the simplest in the world.
                                               // It is a solid green rectangle.
            drawDot(g,x,y);
        }
        showName(g,"Libya");
    }

    public static void flagOfMonaco (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (y < 325)                       // top stripe
                Expo.setColor(g,Expo.red);
            else                               // bottom stripe
                Expo.setColor(g,Expo.white);

            drawDot(g,x,y);
        }
        showName(g,"Monaco");
    }

    public static void flagOfItaly (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (x < 333)                       // left stripe
                Expo.setColor(g,Expo.green);

            if (x >= 333 && x < 667)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (x >= 667)                      // right stripe
                Expo.setColor(g,Expo.red);

            drawDot(g,x,y);
        }
        showName(g,"Italy");
    }

    public static void flagOfBelgium (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (x < 333)                       // left stripe
                Expo.setColor(g,Expo.black);

            if (x >= 333 && x < 667)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.yellow);

            if (x >= 667)                      // right stripe
                Expo.setColor(g,Expo.red);

            drawDot(g,x,y);
        }
        showName(g,"Belgium");
    }

    public static void flagOfIreland (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (x < 333)                       // left stripe
                Expo.setColor(g,Expo.green);

            if (x >= 333 && x < 667)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (x >= 667)                      // right stripe
                Expo.setColor(g,Expo.orange);

            drawDot(g,x,y);
        }
        showName(g,"Ireland");
    }

    public static void flagOfGermany (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (y < 217)                       // left stripe
                Expo.setColor(g,Expo.black);

            if (y >= 217 && y < 434)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);

            if (y >= 434)                      // right stripe
                Expo.setColor(g,Expo.yellow);

            drawDot(g,x,y);
        }
        showName(g,"Germany");
    }

    public static void flagOfAustria (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (y < 217)                       // left stripe
                Expo.setColor(g,Expo.red);

            if (y >= 217 && y < 434)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (y >= 434)                      // right stripe
                Expo.setColor(g,Expo.red);

            drawDot(g,x,y);
        }
        showName(g,"Austria");
    }

    public static void flagOfMauritius (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (y < 162)                       // left stripe
                Expo.setColor(g,Expo.darkRed);

            if (y >= 162 && y < 325)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.darkBlue);

            if (y >= 325 && y < 487)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.gold);
                
            if (y >= 487)                      // right stripe
                Expo.setColor(g,Expo.darkGreen);

            drawDot(g,x,y);
        }
        showName(g,"Mauritius");
    }
    
    public static void flagOfGelderland (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (y < 130)                       // left stripe
                Expo.setColor(g,Expo.red);

            if (y >= 130 && y < 260)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (y >= 260 && y < 390)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.blue);
            
            if (y >= 390 && y < 520)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.gold);    
            
            if (y >= 520)                      // right stripe
                Expo.setColor(g,Expo.black);

            drawDot(g,x,y);
        }
        showName(g,"Gelderland");
    }
    
    public static void flagOfBerlaar (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot

            if (x < 143)                       // left stripe
                Expo.setColor(g,Expo.blue);

            if (x >= 143 && x < 285)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (x >= 285 && x < 428)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.blue);
            
            if (x >= 428 && x < 572)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);    
            
            if (x >= 572 && x < 715)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.blue);
            
            if (x >= 715 && x < 855 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);
            
            if (x >= 855)                      // right stripe
                Expo.setColor(g,Expo.blue);

            drawDot(g,x,y);
        }
        showName(g,"Berlaar");
    }
    
    public static void flagOfLima (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot
            
            if(x<=500&&y<=325||x>=500&&y>=325)
               Expo.setColor(g,Expo.yellow);
            else
               Expo.setColor(g,Expo.black);
            drawDot(g,x,y);
        }
        showName(g,"Lima");
    }
    
    public static void flagOfDenmark (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot
            
            if(x<=275&&x>=225||y>=300&&y<350)
               Expo.setColor(g,Expo.white);
            else
               Expo.setColor(g,Expo.red);
            drawDot(g,x,y);
        }
        showName(g,"Denmark");
    }
    
    public static void flagOfUSA (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot
            
            if (y < 50 && x > 430)                       // left stripe
                Expo.setColor(g,Expo.red);

            if (y >= 50 && y < 100 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);

            if (y >= 100 && y < 150 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);
            
            if (y >= 150 && y < 200 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);    
            
            if (y >= 200 && y < 250 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);
            
            if (y >= 250 && y < 300 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);
            
            if (y >= 300 && y < 350 && x > 430)           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);
                
            if (y >= 350 && y < 400 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);
            
            if (y >= 400 && y < 450 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);
            
            if (y >= 450 && y < 500 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);
            
            if (y >= 500 && y < 550 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.red);
              
            if (y >= 550 && y < 600 )           // middle stripe requires compound condition
                Expo.setColor(g,Expo.white);
                
            if (y >= 600)                      // right stripe
                Expo.setColor(g,Expo.red);
            
            if(x <= 430 && y <= 350)
                Expo.setColor(g,Expo.blue);
            drawDot(g,x,y);
        }
        Expo.setColor(g,Expo.white);
        fiftyStars(g);
        showName(g,"USA");
    }
    
    public static void flagOfJapan (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot
            
            if(distance(x,y,500,325)<=100)
               Expo.setColor(g,Expo.red);
            else
               Expo.setColor(g,Expo.white);
            drawDot(g,x,y);
        }
        showName(g,"Japan");
    }
    
    public static void flagOfEarth (Graphics g)
    {
        Expo.setBackground(g,Expo.black);
        for (int d = 1; d <= numDots; d++)
        {
            int x = Expo.random(0,1000);       // random x value of each dot
            int y = Expo.random(0,650);        // random y value of each dot
            
            if(distance(x,y,500,325)<=150)
               Expo.setColor(g,Expo.blue);
            else if(distance(x,y,800,500)<=50)
               Expo.setColor(g,Expo.white);
            else if(distance(x,y,0,325)<=400)
               Expo.setColor(g,Expo.yellow);
            else
               Expo.setColor(g,Expo.black);
            drawDot(g,x,y);
        }
        showName(g,"Earth");
    }
    
}

