package game;

import edu.monash.fit2099.engine.Location;

public class Corpse extends PortableItem {
	
	private int age = 0;

	public Corpse(String name, char displayChar) {
		super(name, displayChar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		
		// increase day by 1
		age++;

	}
	

}
