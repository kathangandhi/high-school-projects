
import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class paymentLab extends Applet
{

    public void paint(Graphics g)
    {
        Expo.setColor(g, Expo.green);
        Expo.fillRectangle(g,0,0,1000,1000);
        Font header = new Font("Arial", Font.BOLD, 36);//Font Size 
        g.setFont(header);
        Expo.setColor(g, Expo.red);
        g.drawString("Mortgage Payment Calculator", 50, 50);
        
        //Prompt for the principal, term, and rate from the user.
        String principal = JOptionPane.showInputDialog("What is total loan amount?");
        String term = JOptionPane.showInputDialog("How many years is the mortgage?");
        String rate = JOptionPane.showInputDialog("What is the annual interest rate?");
        
        //Converte string values into doubles, principal has been done for you, you should convert the term and rate.
        double p = Double.parseDouble(principal);
        double n = Double.parseDouble(term);
        double r = Double.parseDouble(rate);
        
        //Convert the term of the loan from years to months.
         n = n*12;
        
        //Convert the annual interest rate, apr, to monthly rate, r, - divide apr by 1200
        r = (r/1200);
        
        //Calculate the monthly payment based on the formula in the instructions
        double numerator = Math.pow((1+r), n)*r;
        double denominator = Math.pow((1+r), n)-1;
        double payment = (numerator/denominator)*p*100;
        
        //Round the payment to the nearest penny
        double penny = Math.round(payment);
        double monthlypayment = penny/100;
        
        //Calculate total payments and the total interest
        double total = monthlypayment*n;
        double totalinterest = total - p;
        
        //Output all the information as shown in the example.
        Font lines = new Font("Arial", Font.BOLD, 28);
        g.setFont(lines);
        Expo.setColor(g, Expo.blue);
        g.drawString("Principal: "+p, 50, 100);
        
        //Info
        Expo.setColor(g, Expo.blue);
        Expo.fillRectangle(g,100,200,800,480);
        Expo.setColor(g, Expo.black);
        Font info = new Font("Arial", Font.BOLD, 20);
        g.drawString("Monthly Payment: "+monthlypayment, 110,250);
        g.drawString("Total Amount: "+total, 110,350);
        g.drawString("Interest: "+totalinterest, 110, 450);
       
       
       




    }

}


