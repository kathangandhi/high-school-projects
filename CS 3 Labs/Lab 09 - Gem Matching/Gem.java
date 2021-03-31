import java.awt.Color;
import java.awt.Font;

enum GemType{
	GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem{
	//static variables
	private static final int[] pointVals = {0,5,10,15,20,25,30,35,40,45,50};

	//instance variables
	private GemType color;
	private int points;

	public Gem(){
		//finding gem color
		int random = (int) (Math.random()*3);
		switch(random){
		case 0:
			this.color = GemType.GREEN;
			break;
		case 1:
			this.color = GemType.BLUE;
			break;
		case 2:
			this.color = GemType.ORANGE;
			break;
		}

		//finding gem point value
		random = (int) (Math.random()*pointVals.length);
		this.points = pointVals[random];
	}

	public Gem(GemType type, int points){
		this.color = type;
		this.points =  points;
	}

	public String toString(){
		return color.name()+" "+points;
	}

	public GemType getType(){
		return this.color;
	}

	public int getPoints(){
		return this.points;
	}

	public void draw(double x, double y){
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.setFont(new Font("SansSerif",Font.BOLD,14));
		switch(color){
		case GREEN:
			StdDraw.picture(x, y, "gem_green.png");
			StdDraw.text(x, y, ""+points);
			break;
		case BLUE:
			StdDraw.picture(x, y, "gem_blue.png");
			StdDraw.text(x, y, ""+points);
			break;
		case ORANGE:
			StdDraw.picture(x, y, "gem_orange.png");
			StdDraw.text(x, y, ""+points);
			break;
		}
	}

	/** Tester main method */
	public static void main(String [] args){
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);

		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
}
