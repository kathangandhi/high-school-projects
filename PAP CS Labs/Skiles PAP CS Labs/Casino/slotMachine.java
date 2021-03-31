

public class slotMachine
{
 private char s1;
 private char s2;
 private char s3;
 private char s4;
 private double cashBox;
 
 slotMachine()
 {
  cashBox=1000; 
 }
 
 public double play(double pay)
 {
  if (pay!=25)
  {
   System.out.println("It costs $25 per play");
   System.out.println("Your payment has been returned");
   return pay;
  }
  else
  {
   double winnings;
   int A=0;
   int B=0;
   int C=0;
   int D=0;
   cashBox+=pay;
   s1 = (char) Expo.random(65, 68);
   s2 = (char) Expo.random(65, 68);
   s3 = (char) Expo.random(65, 68);
   s4 = (char) Expo.random(65, 68);
   
   if(s1=='A')
    A++;
   if(s2=='A')
    A++;
   if(s3=='A')
    A++;
   if(s4=='A')
    A++;
   if(s1=='B')
    B++;
   if(s2=='B')
    B++;
   if(s3=='B')
    B++;
   if(s4=='B')
    B++;
   if(s1=='C')
    C++;
   if(s2=='C')
    C++;
   if(s3=='C')
    C++;
   if(s4=='C')
    C++;
   if(s1=='D')
    D++;
   if(s2=='D')
    D++;
   if(s3=='D')
    D++;
   if(s4=='D')
    D++;
   System.out.println(s1+" "+s2+" "+s3+" "+s4);
   winnings=checkWin(A,B,C,D);
   System.out.println("Your winnings are $"+winnings);
   cashBox-=winnings;
   return winnings;
  }
 }
 
 private double checkWin(int A, int B, int C, int D)
 {
  double win=0.0;
  if(A==2)
   win=0.01*cashBox;
  if(B==2)
   win=0.01*cashBox;
  if(C==2)
   win=0.01*cashBox;
  if(D==2)
   win=0.01*cashBox;
  if(A==3)
   win=0.2*cashBox;
  if(B==3)
   win=0.2*cashBox;
  if(C==3)
   win=0.2*cashBox;
  if(D==3)
   win=0.2*cashBox;
  if(A==4)
   win=0.5*cashBox;
  if(B==4)
   win=0.5*cashBox;
  if(C==4)
   win=0.5*cashBox;
  if(D==4)
   win=0.5*cashBox;

  return win;
 }
}
