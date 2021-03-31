public class Runner {

public static void main(String args[]){
	SoundLabProbs music = new SoundLabProbs();
	music.triangle(3);
	System.out.println(music.lastIndexOf(new int[] {3,5,1,6,8,9},5));
	System.out.println(music.range(new int[] {8,3,5,7,2,4}));
	System.out.println(music.minDifference(new int[]{4,8,6,1,5,9,4}));
	System.out.println(music.priceIsRight(new int[] {900,990,1,885}, 800));
}
}
