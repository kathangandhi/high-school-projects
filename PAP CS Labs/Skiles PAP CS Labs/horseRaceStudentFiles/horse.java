 

import java.awt.Graphics;
import java.applet.*;
import java.awt.Color;

class horse
{
 private String horseName;
 private int speed;
 private int xPos;
 private int yPos;
 
  public horse()
 {
  horseName="Blank";
  speed=Expo.random(5,10);
 }
 public horse(String name, int spd)
 {
  horseName=name;
  speed=spd;
 }

 public void setPosition(int x, int y)
 {
  xPos=x;
  yPos=y;
 }
 
 public void showHorse(Graphics g)
 {
  Expo.setColor(g,Expo.red);
  Expo.fillCircle(g,xPos,yPos,15);
  
 }

 public String getName()
 {
  return horseName;
 }
 
 public int getPosition()
 {
  return xPos;
 }
 public int getLane()
 {
  return yPos;
 }
 public int runHorse()
 {
  int steps=Expo.random(4,speed);
  return speed;
 }
 private void hideHorse(Graphics g)
 {
  Expo.setColor(g,Expo.white);
  Expo.fillCircle(g,xPos,yPos,15);
 }
 public void run(Graphics g)
 {
  hideHorse(g);
  int position=getPosition();
  int lane=getLane();
  int step=runHorse();
  position+=step;
  setPosition(position,lane);
  showHorse(g);
  
 }
 
}