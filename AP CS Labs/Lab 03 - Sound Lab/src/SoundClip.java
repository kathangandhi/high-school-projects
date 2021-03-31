import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SoundClip {
	double clip[];
	private double textFiles[];
	
	public SoundClip() {
		clip = null;
	}
	
	public SoundClip(double[] param){
		clip = param;
	}
	
	public void adjustVolume(double factor){
		for(int x = 0; x < clip.length; x++)
			clip[x]*=factor;
	}
	
	public void join(double[] clip1, double[] clip2){
		clip = new double[clip1.length + clip2.length];
		
		for(int i = 0; i < clip1.length; i++)
			clip[i] = clip1[i];
		
		for(int i = clip.length; i < clip.length; i++)
			clip[i] = clip2[i]; 
	}
	
	public void mix(double[] clip1, double[] clip2){
		clip = new double[Math.max(clip1.length, clip2.length)]; 
		
		for(int i = 0;  i < clip.length; i++){
			if(clip1.length > i && clip2.length > i)
				clip[i] = clip1[i] + clip2[i];
			if(clip1.length < i)
				clip[i] = clip2[i];
			else if(clip2.length < i)
				clip[i] = clip2[i];
		}
	}
	
	public void fadeIn(double seconds){
		double num = Sound.toNumSamples(seconds);
		for(int i = 0; i < clip.length; i++)
			clip[i]*=i/num;
	}
	
	public void fadeOut(double seconds){
		double num = Sound.toNumSamples(seconds);
		for(int i = clip.length - (int)num; i < clip.length; i++)
			clip[i]*=(clip.length-i)/num;
		    num--;
	}
	
	public static double[] adjustVolume(double[] newClip, double factor){
		for(int x = 0; x < newClip.length; x++)
			newClip[x]*=factor;
		return newClip;
	}
	
	public void harmonicTone(double frequency, double seconds, String amplitudeFiles) throws FileNotFoundException{
		/*double[] clip1 = Sound.pureTone(frequency, seconds);
		double[] clip2 = Sound.pureTone(frequency*2, seconds);
		double[] clip3 = Sound.pureTone(frequency*3, seconds);
		double[] clip4 = Sound.pureTone(frequency*4, seconds);
		double[] clip5 = Sound.pureTone(frequency*5, seconds);
		
		File file = new File("amplitudes.txt");
		Scanner input = new Scanner(file);
		clip1 = adjustVolume(clip1, input.nextDouble());
		clip2 = adjustVolume(clip2, input.nextDouble());
		clip3 = adjustVolume(clip3, input.nextDouble());
		clip4 = adjustVolume(clip4, input.nextDouble());
		clip5 = adjustVolume(clip5, input.nextDouble());
		
		mix(clip1, clip2);
		mix(clip, clip3);
		mix(clip, clip4);
		mix(clip, clip5);*/
		
		File file = new File("amplitudes.txt");
		Scanner input = new Scanner(file);
		
		clip = Sound.pureTone(frequency, seconds);
		clip = adjustVolume(clip, input.nextDouble());
		
		int factor = 2;
		while(input.hasNext()){
			double[] otherClip = Sound.pureTone(frequency * factor, seconds);
			otherClip = adjustVolume(otherClip, input.nextDouble());
			mix(clip, otherClip);
			factor++;
		}
			
	}
}
