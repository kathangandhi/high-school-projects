public class Initializer 
{    
	public static void initializeWorld()    
	{        
		kareltherobot.World.setSize(12, 12);        
		kareltherobot.World.setDelay(50);        
		kareltherobot.World.readWorld(".", "world.kwld");        
		kareltherobot.World.showSpeedControl(true);        
		     
		builder = new kareltherobot.WorldBuilder(true);
        kareltherobot.World.setVisible(true);   
	}
    static kareltherobot.WorldBuilder builder = null; 
}
